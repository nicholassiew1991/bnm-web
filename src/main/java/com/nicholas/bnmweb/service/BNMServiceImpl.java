package com.nicholas.bnmweb.service;

import com.nicholas.bnmweb.dto.bnm.response.FinancialConsumerAlertResponse;
import com.nicholas.bnmweb.helpers.JsonHelper;
import com.nicholas.bnmweb.service.interfaces.BNMService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BNMServiceImpl implements BNMService {

	private static final String CONSUMER_ALERT_ENDPOINT = "https://api.bnm.gov.my/public/consumer-alert";

	private final OkHttpClient okHttpClient;

	public BNMServiceImpl(@Qualifier("bnmOkHttpClient") OkHttpClient okHttpClient) {
		this.okHttpClient = okHttpClient;
	}

	public void getConsumerAlert() {

		var response = this.sendBnmRequest(CONSUMER_ALERT_ENDPOINT, FinancialConsumerAlertResponse.class);

		System.out.println(response.getMeta().getTotalResult());
		System.out.println(response.getMeta().getLastUpdate());

		response.getData().stream().forEach(x -> {
			System.out.println(x.getName());
		});
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
