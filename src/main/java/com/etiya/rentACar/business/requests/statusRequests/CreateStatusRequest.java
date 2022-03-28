package com.etiya.rentACar.business.requests.statusRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStatusRequest {
	
	@JsonIgnore //Verilen alan son kullanıcıya gösterilmez. Kullanıcı buna giriş yapamaz.
	private int statusId;

	private String statusName;
}
