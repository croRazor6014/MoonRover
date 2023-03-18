package org.example.moonrover.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.moonrover.model.Coordinates;
import org.example.moonrover.model.Rotation;
import org.example.moonrover.model.exception.ObjectAlreadyExistsException;
import org.example.moonrover.model.exception.OutsideBoundsException;
import org.example.moonrover.service.TableTopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  created by lovro.vrlec@gmail.com on Mar,2023
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class RoverController {

    private final TableTopService tableTopService;

    @Operation(summary = "Places rover on tabletop")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rover placed on tabletop",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Coordinates.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid tabletop position supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Rover not found",
                    content = @Content) })
    @PostMapping("api/rover/place")
    public ResponseEntity<Coordinates> place(@RequestBody Coordinates request)
            throws ObjectAlreadyExistsException, OutsideBoundsException {


        tableTopService.placeRover(request);
        return ResponseEntity.ok(request);

    }

    @Operation(summary = "Turns rover direction on tabletop")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rover turned to desired direction",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid turn direction supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Rover not found",
                    content = @Content) })
    @PostMapping("api/rover/turn")
    public ResponseEntity<String> turn(@RequestBody Rotation request){
        return ResponseEntity.ok().body("rotated "+tableTopService.rotateRover(request));
    }

    @Operation(summary = "Places rover on tabletop")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rover moved forward one step on tabletop",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "400", description = "Rover unable to move in that direction",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Rover not found",
                    content = @Content) })
    @PostMapping("api/rover/move")
    public ResponseEntity<String> move() throws ObjectAlreadyExistsException {
        return ResponseEntity.ok().body("moved "+tableTopService.moveRover());

    }


    @Operation(summary = "Places rover on tabletop")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rover placed on tabletop",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Coordinates.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid tabletop position supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Rover not found",
                    content = @Content) })
    @GetMapping("api/rover/report")
    public ResponseEntity<Coordinates> report(){
        return ResponseEntity.ok().body(tableTopService.reportRover());

    }
}
