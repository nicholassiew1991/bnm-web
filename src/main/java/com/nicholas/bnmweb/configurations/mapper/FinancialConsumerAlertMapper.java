package com.nicholas.bnmweb.configurations.mapper;

import com.nicholas.bnmweb.dto.bnm.response.FinancialConsumerAlertDetailsResponse;
import com.nicholas.bnmweb.entities.mongo.FinancialConsumerAlertEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FinancialConsumerAlertMapper {

	FinancialConsumerAlertMapper INSTANCE = Mappers.getMapper(FinancialConsumerAlertMapper.class);

	@Mappings({
		@Mapping(target = "id", ignore = true)
	})
	FinancialConsumerAlertEntity responseObjectToEntity(FinancialConsumerAlertDetailsResponse response);
}
