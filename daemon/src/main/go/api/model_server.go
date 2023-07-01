/*
 * MiniCloud API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * API version: 1.0.0
 * Contact: apiteam@swagger.io
 * Generated by: OpenAPI Generator (https://openapi-generator.tech)
 */

package api

type Server struct {
	Name string `json:"name,omitempty"`

	Group string `json:"group,omitempty"`

	IpAddress string `json:"ip-address,omitempty"`

	// Server Status
	Status string `json:"status,omitempty"`

	OnlinePlayers int32 `json:"online-players,omitempty"`
}

// AssertServerRequired checks if the required fields are not zero-ed
func AssertServerRequired(obj Server) error {
	return nil
}

// AssertRecurseServerRequired recursively checks if required fields are not zero-ed in a nested slice.
// Accepts only nested slice of Server (e.g. [][]Server), otherwise ErrTypeAssertionError is thrown.
func AssertRecurseServerRequired(objSlice interface{}) error {
	return AssertRecurseInterfaceRequired(objSlice, func(obj interface{}) error {
		aServer, ok := obj.(Server)
		if !ok {
			return ErrTypeAssertionError
		}
		return AssertServerRequired(aServer)
	})
}
