package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.InvoiceService;
import com.etiya.rentACar.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.DeleteInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.UpdateInvoiceRequest;
import com.etiya.rentACar.business.responses.invoiceResponses.ListInvoiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/invoicies")
public class InvoiciesController {
    private InvoiceService invoiceService;

    public InvoiciesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateInvoiceRequest createInvoiceRequest){
        return this.invoiceService.add(createInvoiceRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateInvoiceRequest updateInvoiceRequest){
        return this.invoiceService.update(updateInvoiceRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteInvoiceRequest deleteInvoiceRequest){
        return this.invoiceService.delete(deleteInvoiceRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<ListInvoiceDto>> getAll(){
        return this.invoiceService.getAll();
    }

    @GetMapping("/findCreateDate")
    public DataResult<List<ListInvoiceDto>> findCreateDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate ){
        return this.invoiceService.findByCreateDateBetween(startDate,endDate);
    }

    @GetMapping("/getAllCustomerId")
    public DataResult<List<ListInvoiceDto>> getByCustomerId(@RequestParam int customerId){
        return this.invoiceService.getByCustomerId(customerId);
    }
}