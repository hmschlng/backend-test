package com.ssafy.backtest.member.util;

import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

@Component
public class PasswordEncoder {
	public static String getSha256Hashcode(String pass) {
		Hasher hasher = Hashing.sha256().newHasher();
		hasher.putString(pass, Charsets.UTF_8);
		HashCode sha256 = hasher.hash();
		return sha256.toString();
	}
}
