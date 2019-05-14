package com.nicholas.bnmweb.service;

import com.nicholas.bnmweb.configurations.mapper.FinancialConsumerAlertMapper;
import com.nicholas.bnmweb.dto.bnm.response.FinancialConsumerAlertResponse;
import com.nicholas.bnmweb.helpers.JsonHelper;
import com.nicholas.bnmweb.repository.mongodb.FinancialConsumerAlertRepository;
import com.nicholas.bnmweb.service.interfaces.BNMService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BNMServiceImpl implements BNMService {

	private static final String CONSUMER_ALERT_ENDPOINT = "https://api.bnm.gov.my/public/consumer-alert";

	private final FinancialConsumerAlertRepository financialConsumerAlertRepository;
	private final OkHttpClient okHttpClient;

	public BNMServiceImpl(
		FinancialConsumerAlertRepository financialConsumerAlertRepository,
		@Qualifier("bnmOkHttpClient") OkHttpClient okHttpClient) {
		this.financialConsumerAlertRepository = financialConsumerAlertRepository;
		this.okHttpClient = okHttpClient;
	}

	public void getConsumerAlert() {

		var response = this.sendBnmRequest(CONSUMER_ALERT_ENDPOINT, FinancialConsumerAlertResponse.class);
		var records = response.getData().stream()
			.map(FinancialConsumerAlertMapper.INSTANCE::responseObjectToEntity)
			.collect(Collectors.toList());

		financialConsumerAlertRepository.saveAll(records);
	}

	private <R> R sendBnmRequest(String url, Class<R> clazz) {

		var request = new Request.Builder()
			.url(url)
			.build();

		try (var response = okHttpClient.newCall(request).execute()) {
			var body = response.body().string();
			return JsonHelper.toObject(body, clazz);
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
