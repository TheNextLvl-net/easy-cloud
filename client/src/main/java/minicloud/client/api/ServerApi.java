/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package minicloud.client.api;

import minicloud.client.model.Server;
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
@Tag(name = "server", description = "Operations about the servers")
public interface ServerApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/server : Create a new server
     *
     * @param body Create a new server (required)
     * @return Successful operation (status code 201)
     *         or Invalid input (status code 400)
     *         or Server already exists (status code 409)
     */
    @Operation(
        operationId = "createServer",
        summary = "Create a new server",
        tags = { "server" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Server.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Server already exists")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/server",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Server> createServer(
        @Parameter(name = "body", description = "Create a new server", required = true) @Valid@Pattern(regexp = "^[a-zA-Z0-9-_]+$")  @RequestBody String body
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ip-address\" : \"10.0.0.11\", \"online-players\" : 4, \"name\" : \"lobby-1\", \"group\" : \"lobby\", \"status\" : \"starting\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/server/{name} : Get the server
     *
     * @param name Name of the server (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Server not found (status code 404)
     */
    @Operation(
        operationId = "getServer",
        summary = "Get the server",
        tags = { "server" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Server.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Server not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/server/{name}",
        produces = { "application/json" }
    )
    default ResponseEntity<Server> getServer(
        @Pattern(regexp = "^[a-zA-Z0-9-_]+$") @Parameter(name = "name", description = "Name of the server", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ip-address\" : \"10.0.0.11\", \"online-players\" : 4, \"name\" : \"lobby-1\", \"group\" : \"lobby\", \"status\" : \"starting\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/server : Get all servers
     *
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "getServers",
        summary = "Get all servers",
        tags = { "server" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Server.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/server",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Server>> getServers(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"ip-address\" : \"10.0.0.11\", \"online-players\" : 4, \"name\" : \"lobby-1\", \"group\" : \"lobby\", \"status\" : \"starting\" }, { \"ip-address\" : \"10.0.0.11\", \"online-players\" : 4, \"name\" : \"lobby-1\", \"group\" : \"lobby\", \"status\" : \"starting\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/server/{name} : Delete an existing server
     *
     * @param name Name of the server (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Server not found (status code 404)
     */
    @Operation(
        operationId = "removeServer",
        summary = "Delete an existing server",
        tags = { "server" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Server not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/server/{name}"
    )
    default ResponseEntity<Void> removeServer(
        @Pattern(regexp = "^[a-zA-Z0-9-_]+$") @Parameter(name = "name", description = "Name of the server", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /server/{name}/start : Start the server
     *
     * @param name Name of the server (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Server not found (status code 404)
     */
    @Operation(
        operationId = "startServer",
        summary = "Start the server",
        tags = { "server" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Server not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/server/{name}/start"
    )
    default ResponseEntity<Void> startServer(
        @Pattern(regexp = "^[a-zA-Z0-9-_]+$") @Parameter(name = "name", description = "Name of the server", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /server/{name}/stop : Stop the server
     *
     * @param name Name of the server (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Server not found (status code 404)
     */
    @Operation(
        operationId = "stopServer",
        summary = "Stop the server",
        tags = { "server" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Server not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/server/{name}/stop"
    )
    default ResponseEntity<Void> stopServer(
        @Pattern(regexp = "^[a-zA-Z0-9-_]+$") @Parameter(name = "name", description = "Name of the server", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
