// Code generated by protoc-gen-go. DO NOT EDIT.
// source: UserFacade.proto

package com_chenhaibo_grpc_userfacade

import (
	context "context"
	fmt "fmt"
	proto "github.com/golang/protobuf/proto"
	_ "google.golang.org/genproto/googleapis/api/annotations"
	grpc "google.golang.org/grpc"
	math "math"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.ProtoPackageIsVersion3 // please upgrade the proto package

type UserParam struct {
	Name                 string   `protobuf:"bytes,1,opt,name=name,proto3" json:"name,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *UserParam) Reset()         { *m = UserParam{} }
func (m *UserParam) String() string { return proto.CompactTextString(m) }
func (*UserParam) ProtoMessage()    {}
func (*UserParam) Descriptor() ([]byte, []int) {
	return fileDescriptor_4688bce4153775ca, []int{0}
}

func (m *UserParam) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_UserParam.Unmarshal(m, b)
}
func (m *UserParam) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_UserParam.Marshal(b, m, deterministic)
}
func (m *UserParam) XXX_Merge(src proto.Message) {
	xxx_messageInfo_UserParam.Merge(m, src)
}
func (m *UserParam) XXX_Size() int {
	return xxx_messageInfo_UserParam.Size(m)
}
func (m *UserParam) XXX_DiscardUnknown() {
	xxx_messageInfo_UserParam.DiscardUnknown(m)
}

var xxx_messageInfo_UserParam proto.InternalMessageInfo

func (m *UserParam) GetName() string {
	if m != nil {
		return m.Name
	}
	return ""
}

type UserResult struct {
	Id                   string   `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	Name                 string   `protobuf:"bytes,2,opt,name=name,proto3" json:"name,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *UserResult) Reset()         { *m = UserResult{} }
func (m *UserResult) String() string { return proto.CompactTextString(m) }
func (*UserResult) ProtoMessage()    {}
func (*UserResult) Descriptor() ([]byte, []int) {
	return fileDescriptor_4688bce4153775ca, []int{1}
}

func (m *UserResult) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_UserResult.Unmarshal(m, b)
}
func (m *UserResult) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_UserResult.Marshal(b, m, deterministic)
}
func (m *UserResult) XXX_Merge(src proto.Message) {
	xxx_messageInfo_UserResult.Merge(m, src)
}
func (m *UserResult) XXX_Size() int {
	return xxx_messageInfo_UserResult.Size(m)
}
func (m *UserResult) XXX_DiscardUnknown() {
	xxx_messageInfo_UserResult.DiscardUnknown(m)
}

var xxx_messageInfo_UserResult proto.InternalMessageInfo

func (m *UserResult) GetId() string {
	if m != nil {
		return m.Id
	}
	return ""
}

func (m *UserResult) GetName() string {
	if m != nil {
		return m.Name
	}
	return ""
}

func init() {
	proto.RegisterType((*UserParam)(nil), "com.chenhaibo.grpc.userfacade.UserParam")
	proto.RegisterType((*UserResult)(nil), "com.chenhaibo.grpc.userfacade.UserResult")
}

func init() { proto.RegisterFile("UserFacade.proto", fileDescriptor_4688bce4153775ca) }

var fileDescriptor_4688bce4153775ca = []byte{
	// 212 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x09, 0x6e, 0x88, 0x02, 0xff, 0xe2, 0x12, 0x08, 0x2d, 0x4e, 0x2d,
	0x72, 0x4b, 0x4c, 0x4e, 0x4c, 0x49, 0xd5, 0x2b, 0x28, 0xca, 0x2f, 0xc9, 0x17, 0x92, 0x4d, 0xce,
	0xcf, 0xd5, 0x4b, 0xce, 0x48, 0xcd, 0xcb, 0x48, 0xcc, 0x4c, 0xca, 0xd7, 0x4b, 0x2f, 0x2a, 0x48,
	0xd6, 0x2b, 0x2d, 0x4e, 0x2d, 0x4a, 0x03, 0x2b, 0x92, 0x92, 0x49, 0xcf, 0xcf, 0x4f, 0xcf, 0x49,
	0xd5, 0x4f, 0x2c, 0xc8, 0xd4, 0x4f, 0xcc, 0xcb, 0xcb, 0x2f, 0x49, 0x2c, 0xc9, 0xcc, 0xcf, 0x2b,
	0x86, 0x68, 0x56, 0x92, 0xe7, 0xe2, 0x04, 0x19, 0x18, 0x90, 0x58, 0x94, 0x98, 0x2b, 0x24, 0xc4,
	0xc5, 0x92, 0x97, 0x98, 0x9b, 0x2a, 0xc1, 0xa8, 0xc0, 0xa8, 0xc1, 0x19, 0x04, 0x66, 0x2b, 0x19,
	0x70, 0x71, 0x81, 0x14, 0x04, 0xa5, 0x16, 0x97, 0xe6, 0x94, 0x08, 0xf1, 0x71, 0x31, 0x65, 0xa6,
	0x40, 0xe5, 0x99, 0x32, 0x53, 0xe0, 0x3a, 0x98, 0x10, 0x3a, 0x8c, 0xda, 0x18, 0x21, 0x5a, 0x20,
	0x8e, 0x14, 0xaa, 0xe0, 0x62, 0x4f, 0x4f, 0x2d, 0x01, 0x09, 0x08, 0x69, 0xe8, 0xe1, 0x75, 0xaa,
	0x1e, 0xdc, 0x25, 0x52, 0x9a, 0x44, 0xa8, 0x84, 0x38, 0x49, 0x49, 0xa2, 0xe9, 0xf2, 0x93, 0xc9,
	0x4c, 0x42, 0x4a, 0xbc, 0xfa, 0x20, 0x79, 0x7d, 0xa8, 0x5d, 0x56, 0x8c, 0x5a, 0x4e, 0x4c, 0x01,
	0x8c, 0x49, 0x6c, 0x60, 0x6f, 0x1a, 0x03, 0x02, 0x00, 0x00, 0xff, 0xff, 0xa2, 0xcb, 0x79, 0x2c,
	0x37, 0x01, 0x00, 0x00,
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion4

// UserFacadeClient is the client API for UserFacade service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://godoc.org/google.golang.org/grpc#ClientConn.NewStream.
type UserFacadeClient interface {
	GetUser(ctx context.Context, in *UserParam, opts ...grpc.CallOption) (*UserResult, error)
}

type userFacadeClient struct {
	cc *grpc.ClientConn
}

func NewUserFacadeClient(cc *grpc.ClientConn) UserFacadeClient {
	return &userFacadeClient{cc}
}

func (c *userFacadeClient) GetUser(ctx context.Context, in *UserParam, opts ...grpc.CallOption) (*UserResult, error) {
	out := new(UserResult)
	err := c.cc.Invoke(ctx, "/com.chenhaibo.grpc.userfacade.UserFacade/getUser", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// UserFacadeServer is the server API for UserFacade service.
type UserFacadeServer interface {
	GetUser(context.Context, *UserParam) (*UserResult, error)
}

func RegisterUserFacadeServer(s *grpc.Server, srv UserFacadeServer) {
	s.RegisterService(&_UserFacade_serviceDesc, srv)
}

func _UserFacade_GetUser_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(UserParam)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(UserFacadeServer).GetUser(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/com.chenhaibo.grpc.userfacade.UserFacade/GetUser",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(UserFacadeServer).GetUser(ctx, req.(*UserParam))
	}
	return interceptor(ctx, in, info, handler)
}

var _UserFacade_serviceDesc = grpc.ServiceDesc{
	ServiceName: "com.chenhaibo.grpc.userfacade.UserFacade",
	HandlerType: (*UserFacadeServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "getUser",
			Handler:    _UserFacade_GetUser_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "UserFacade.proto",
}