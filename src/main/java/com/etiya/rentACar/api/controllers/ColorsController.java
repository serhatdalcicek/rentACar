package com.etiya.rentACar.api.controllers;

import java.util.List;

import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {
	private ColorService colorService;

	public ColorsController(ColorService colorService) {

		this.colorService = colorService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateColorRequest createColorRequest) {

		return this.colorService.add(createColorRequest);
	}
	/*@PutMapping("/update")
    public Result update(@RequestBody  UpdateColorRequest updateColorRequest) {

        return this.colorService.update(updateColorRequest);
    }*/
	/*@DeleteMapping("/delete")
    public Result delete(@RequestBody  DeleteColorRequest deleteColorRequest) {

		return this.colorService.delete(deleteColorRequest);
	}*/
	@GetMapping("/getall")
	public DataResult<List<ListColorDto>> getAll(){

		return this.colorService.getAll();
	}
	/*@GetMapping("/getallpaged")
	 public DataResult<List<ListColorDto>> getAllPaged(int pageNo,int pageSize){

		return this.colorService.getAllPaged(pageNo ,pageSize);
	}*/

}
