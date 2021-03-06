package br.com.andrei.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.andrei.model.VendorDTO;
import br.com.andrei.domain.Vendor;

@Mapper
public interface VendorMapper {

	VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
	
	VendorDTO vendorToVendorDTO(Vendor vendor);
	
	Vendor vendorDTOToVendor(VendorDTO vendorDTO);
}
