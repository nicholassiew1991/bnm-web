package com.nicholas.bnmweb.beans;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BnmOkHttpClientInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
		var newRequest = chain.request().newBuilder()
			.addHeader("Accept", "application/vnd.BNM.API.v1+json")
			.build();
		return chain.proceed(newRequest);
	}
}
