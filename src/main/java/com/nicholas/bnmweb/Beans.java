package com.nicholas.bnmweb;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Beans {

	@Bean("bnmOkHttpClient")
	public OkHttpClient okHttpClient() {

		Interceptor interceptor = chain -> {
			var newRequest = chain.request().newBuilder()
				.addHeader("Accept", "application/vnd.BNM.API.v1+json")
				.build();
			return chain.proceed(newRequest);
		};

		var clientBuilder = new OkHttpClient.Builder()
			.addInterceptor(interceptor);

		return clientBuilder.build();
	}
}
