/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package minicloud.client.api;

import minicloud.client.model.ServerGroup;
import minicloud.client.model.ServerList;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "server group", description = "Operations about the server groups")
public interface ServerGroupApi {

    /**
     * GET /api/v1/group : Get all server groups
     *
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "apiV1GroupGet",
        summary = "Get all server groups",
        tags = { "server group" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ServerGroup.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/group",
        produces = { "application/json" }
    )
    ResponseEntity<List<ServerGroup>> apiV1GroupGet(
        
    );


    /**
     * DELETE /api/v1/group/{name} : Delete an existing server group
     *
     * @param name Name of the server group (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Server group not found (status code 409)
     */
    @Operation(
        operationId = "apiV1GroupNameDelete",
        summary = "Delete an existing server group",
        tags = { "server group" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Server group not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/group/{name}"
    )
    ResponseEntity<Void> apiV1GroupNameDelete(
        @Parameter(name = "name", description = "Name of the server group", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    );


    /**
     * GET /api/v1/group/{name} : Get the server group
     *
     * @param name Name of the server group (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Server group not found (status code 404)
     */
    @Operation(
        operationId = "apiV1GroupNameGet",
        summary = "Get the server group",
        tags = { "server group" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ServerGroup.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Server group not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/group/{name}",
        produces = { "application/json" }
    )
    ResponseEntity<ServerGroup> apiV1GroupNameGet(
        @Parameter(name = "name", description = "Name of the server group", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    );


    /**
     * GET /api/v1/group/{name}/servers : Get all servers of the group
     *
     * @param name Name of the server group (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Server group not found (status code 404)
     */
    @Operation(
        operationId = "apiV1GroupNameServersGet",
        summary = "Get all servers of the group",
        tags = { "server group" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ServerList.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Server group not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/group/{name}/servers",
        produces = { "application/json" }
    )
    ResponseEntity<ServerList> apiV1GroupNameServersGet(
        @Parameter(name = "name", description = "Name of the server group", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    );


    /**
     * POST /api/v1/group : Create a new server group
     *
     * @param serverGroup Create a new server group (required)
     * @return Successful operation (status code 201)
     *         or Invalid input (status code 400)
     *         or Server group already exists (status code 409)
     */
    @Operation(
        operationId = "apiV1GroupPost",
        summary = "Create a new server group",
        tags = { "server group" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ServerGroup.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Server group already exists")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/group",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<ServerGroup> apiV1GroupPost(
        @Parameter(name = "ServerGroup", description = "Create a new server group", required = true) @Valid @RequestBody ServerGroup serverGroup
    );

}
