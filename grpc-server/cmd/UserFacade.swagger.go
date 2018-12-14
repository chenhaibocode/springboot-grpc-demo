package com_chenhaibo_grpc_userfacade

const (
        Swagger = `
        {
				  "swagger": "2.0",
				  "info": {
				    "title": "UserFacade.proto",
				    "version": "version not set"
				  },
				  "schemes": [
				    "http",
				    "https"
				  ],
				  "consumes": [
				    "application/json"
				  ],
				  "produces": [
				    "application/json"
				  ],
				  "paths": {
				    "/user/getUser": {
				      "post": {
				        "operationId": "getUser",
				        "responses": {
				          "200": {
				            "description": "A successful response.",
				            "schema": {
				              "$ref": "#/definitions/userfacadeUserResult"
				            }
				          }
				        },
				        "parameters": [
				          {
				            "name": "body",
				            "in": "body",
				            "required": true,
				            "schema": {
				              "$ref": "#/definitions/userfacadeUserParam"
				            }
				          }
				        ],
				        "tags": [
				          "UserFacade"
				        ]
				      }
				    }
				  },
				  "definitions": {
				    "userfacadeUserParam": {
				      "type": "object",
				      "properties": {
				        "name": {
				          "type": "string"
				        }
				      }
				    },
				    "userfacadeUserResult": {
				      "type": "object",
				      "properties": {
				        "id": {
				          "type": "string"
				        },
				        "name": {
				          "type": "string"
				        }
				      }
				    }
				  }
				}
        `
)
