/*
 * MiniCloud API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * API version: 1.0.0
 * Contact: apiteam@swagger.io
 * Generated by: OpenAPI Generator (https://openapi-generator.tech)
 */

package server

import (
	"encoding/json"
	"net/http"
	"strings"

	"github.com/TheNextLvl-net/mini-cloud/daemon/main/src/go/api"
	"github.com/gorilla/mux"
)

// ServerGroupApiController binds http requests to an api service and writes the service results to the http response
type ServerGroupApiController struct {
	service      ServerGroupApiServicer
	errorHandler ErrorHandler
}

// ServerGroupApiOption for how the controller is set up.
type ServerGroupApiOption func(*ServerGroupApiController)

// WithServerGroupApiErrorHandler inject ErrorHandler into controller
func WithServerGroupApiErrorHandler(h ErrorHandler) ServerGroupApiOption {
	return func(c *ServerGroupApiController) {
		c.errorHandler = h
	}
}

// NewServerGroupApiController creates a default api controller
func NewServerGroupApiController(s ServerGroupApiServicer, opts ...ServerGroupApiOption) Router {
	controller := &ServerGroupApiController{
		service:      s,
		errorHandler: DefaultErrorHandler,
	}

	for _, opt := range opts {
		opt(controller)
	}

	return controller
}

// Routes returns all the api routes for the ServerGroupApiController
func (c *ServerGroupApiController) Routes() Routes {
	return Routes{
		{
			"CreateGroup",
			strings.ToUpper("Post"),
			"/api/v1/group",
			c.CreateGroup,
		},
		{
			"GetGroup",
			strings.ToUpper("Get"),
			"/api/v1/group/{name}",
			c.GetGroup,
		},
		{
			"GetGroups",
			strings.ToUpper("Get"),
			"/api/v1/group",
			c.GetGroups,
		},
		{
			"GetServersInGroup",
			strings.ToUpper("Get"),
			"/api/v1/group/{name}/servers",
			c.GetServersInGroup,
		},
		{
			"RemoveGroup",
			strings.ToUpper("Delete"),
			"/api/v1/group/{name}",
			c.RemoveGroup,
		},
	}
}

// CreateGroup - Create a new server group
func (c *ServerGroupApiController) CreateGroup(w http.ResponseWriter, r *http.Request) {
	serverGroupParam := api.ServerGroup{}
	d := json.NewDecoder(r.Body)
	d.DisallowUnknownFields()
	if err := d.Decode(&serverGroupParam); err != nil {
		c.errorHandler(w, r, &api.ParsingError{Err: err}, nil)
		return
	}
	if err := api.AssertServerGroupRequired(serverGroupParam); err != nil {
		c.errorHandler(w, r, err, nil)
		return
	}
	result, err := c.service.CreateGroup(r.Context(), serverGroupParam)
	// If an error occurred, encode the error with the status code
	if err != nil {
		c.errorHandler(w, r, err, &result)
		return
	}
	// If no error, encode the body and the result code
	EncodeJSONResponse(result.Body, &result.Code, w)

}

// GetGroup - Get the server group
func (c *ServerGroupApiController) GetGroup(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	nameParam := params["name"]
	result, err := c.service.GetGroup(r.Context(), nameParam)
	// If an error occurred, encode the error with the status code
	if err != nil {
		c.errorHandler(w, r, err, &result)
		return
	}
	// If no error, encode the body and the result code
	EncodeJSONResponse(result.Body, &result.Code, w)

}

// GetGroups - Get all server groups
func (c *ServerGroupApiController) GetGroups(w http.ResponseWriter, r *http.Request) {
	result, err := c.service.GetGroups(r.Context())
	// If an error occurred, encode the error with the status code
	if err != nil {
		c.errorHandler(w, r, err, &result)
		return
	}
	// If no error, encode the body and the result code
	EncodeJSONResponse(result.Body, &result.Code, w)

}

// GetServersInGroup - Get all servers of the group
func (c *ServerGroupApiController) GetServersInGroup(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	nameParam := params["name"]
	result, err := c.service.GetServersInGroup(r.Context(), nameParam)
	// If an error occurred, encode the error with the status code
	if err != nil {
		c.errorHandler(w, r, err, &result)
		return
	}
	// If no error, encode the body and the result code
	EncodeJSONResponse(result.Body, &result.Code, w)

}

// RemoveGroup - Delete an existing server group
func (c *ServerGroupApiController) RemoveGroup(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	nameParam := params["name"]
	result, err := c.service.RemoveGroup(r.Context(), nameParam)
	// If an error occurred, encode the error with the status code
	if err != nil {
		c.errorHandler(w, r, err, &result)
		return
	}
	// If no error, encode the body and the result code
	EncodeJSONResponse(result.Body, &result.Code, w)

}
