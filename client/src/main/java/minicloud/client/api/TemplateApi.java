/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package minicloud.client.api;

import minicloud.client.model.Template;
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
@Tag(name = "template", description = "Operations about the server templates")
@RequestMapping("${openapi.miniCloud.base-path:}")
public interface TemplateApi {

    /**
     * POST /api/v1/template : Create a new template
     *
     * @param name Name of the template (required)
     * @param body The tar binary of the template folder (required)
     * @return Successful operation (status code 201)
     *         or Template already exists (status code 409)
     */
    @Operation(
        operationId = "createTemplate",
        summary = "Create a new template",
        tags = { "template" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Template.class))
            }),
            @ApiResponse(responseCode = "409", description = "Template already exists")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/template",
        produces = { "application/json" },
        consumes = { "application/octet-stream" }
    )
    ResponseEntity<Template> createTemplate(
        @NotNull @Pattern(regexp = "^[a-zA-Z0-9-_]+$") @Parameter(name = "name", description = "Name of the template", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "name", required = true) String name,
        @Parameter(name = "body", description = "The tar binary of the template folder", required = true) @Valid @RequestBody org.springframework.core.io.Resource body
    );


    /**
     * GET /api/v1/template/{name}/download : Downloads the template
     *
     * @param name Name of the template (required)
     * @return Successful operation (status code 200)
     *         or Empty template (status code 204)
     *         or Invalid input (status code 400)
     *         or Template not found (status code 404)
     */
    @Operation(
        operationId = "downloadTemplate",
        summary = "Downloads the template",
        tags = { "template" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/octet-stream", schema = @Schema(implementation = org.springframework.core.io.Resource.class))
            }),
            @ApiResponse(responseCode = "204", description = "Empty template"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Template not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/template/{name}/download",
        produces = { "application/octet-stream" }
    )
    ResponseEntity<org.springframework.core.io.Resource> downloadTemplate(
        @Pattern(regexp = "^[a-zA-Z0-9-_]+$") @Parameter(name = "name", description = "Name of the template", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    );


    /**
     * GET /api/v1/template/{name} : Get the template
     *
     * @param name Name of the template (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Template not found (status code 404)
     */
    @Operation(
        operationId = "getTemplate",
        summary = "Get the template",
        tags = { "template" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Template.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Template not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/template/{name}",
        produces = { "application/json" }
    )
    ResponseEntity<Template> getTemplate(
        @Pattern(regexp = "^[a-zA-Z0-9-_]+$") @Parameter(name = "name", description = "Name of the template", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    );


    /**
     * GET /api/v1/template : Get all templates
     *
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "getTemplates",
        summary = "Get all templates",
        tags = { "template" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Template.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/template",
        produces = { "application/json" }
    )
    ResponseEntity<List<Template>> getTemplates(
        
    );


    /**
     * DELETE /api/v1/template/{name} : Delete an existing template
     *
     * @param name Name of the template (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Template in use (status code 403)
     *         or Template not found (status code 404)
     */
    @Operation(
        operationId = "removeTemplate",
        summary = "Delete an existing template",
        tags = { "template" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "403", description = "Template in use"),
            @ApiResponse(responseCode = "404", description = "Template not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/template/{name}"
    )
    ResponseEntity<Void> removeTemplate(
        @Pattern(regexp = "^[a-zA-Z0-9-_]+$") @Parameter(name = "name", description = "Name of the template", required = true, in = ParameterIn.PATH) @PathVariable("name") String name
    );


    /**
     * PUT /api/v1/template : Update the files of the template
     *
     * @param name Name of the template (required)
     * @param body The tar binary of the template folder (required)
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "updateTemplate",
        summary = "Update the files of the template",
        tags = { "template" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Template.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/api/v1/template",
        produces = { "application/json" },
        consumes = { "application/octet-stream" }
    )
    ResponseEntity<Template> updateTemplate(
        @NotNull @Pattern(regexp = "^[a-zA-Z0-9-_]+$") @Parameter(name = "name", description = "Name of the template", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "name", required = true) String name,
        @Parameter(name = "body", description = "The tar binary of the template folder", required = true) @Valid @RequestBody org.springframework.core.io.Resource body
    );

}
