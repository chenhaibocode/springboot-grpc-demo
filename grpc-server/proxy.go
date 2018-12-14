package main

import (
    "io"
	  "strings"
    "flag"
    "log"
    "mime"
    "net/http"
    "github.com/grpc-ecosystem/grpc-gateway/runtime"
    "github.com/elazarl/go-bindata-assetfs"
    "golang.org/x/net/context"
    "google.golang.org/grpc"
    
    gw "../grpc-server/cmd"
    "../grpc-server/cmd/swagger/ui/data"
)

var (
    userEndpoint = flag.String("userfacade_endpoint", "127.0.0.1:9898", "endpoint of User gRPC Service")
)

func serveSwagger(mux *http.ServeMux) {
	  mime.AddExtensionType(".svg", "image/svg+xml")

	  fileServer := http.FileServer(&assetfs.AssetFS{
			Asset:    swagger.Asset,
			AssetDir: swagger.AssetDir,
			Prefix:   "/swagger-ui",
		})
		prefix := "/swagger-ui/"
		mux.Handle(prefix, http.StripPrefix(prefix, fileServer))
}

func run() error {
    ctx := context.Background()
    ctx, cancel := context.WithCancel(ctx)
    defer cancel()

    mux := http.NewServeMux()
    mux.HandleFunc("/swagger.json", func(w http.ResponseWriter, req *http.Request) {
        io.Copy(w, strings.NewReader(gw.Swagger))
    })
    
    gwmux := runtime.NewServeMux()
    opts := []grpc.DialOption{grpc.WithInsecure()}
    err := gw.RegisterUserFacadeHandlerFromEndpoint(ctx, gwmux, *userEndpoint, opts)
    if err != nil {
        return err
    }
    
    mux.Handle("/", gwmux)
	  serveSwagger(mux)

    log.Print("User gRPC Server gateway start at port 8080...")
    http.ListenAndServe(":8080", mux)
    return nil
}

func main() {
    flag.Parse()

    if err := run(); err != nil {
        log.Fatal(err)
    }
}
