package com.aecg.springboot.backend.apirest.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

	public static final String RSA_PRIVADA ="-----BEGIN RSA PRIVATE KEY-----\n" +
			"MIIEpAIBAAKCAQEA1OCOh38tY8tIjSvG9v9DS0qBk71p1kKoX1yesZu2yDpLYyD7\n" +
			"nZZ5b2LDYioY5dXy+LL+jDuZdhs4qzVdAU8vODMrIYxcFkZW4wulkWv+nXofmD2y\n" +
			"7kLdJ/IOZbUMsI6omf41lz7e518f9kNDC19bIu+lmVUbr16UeyIk35vXayOvKju1\n" +
			"1wuEAQ+RcVjBVqdPA2FQdMAf5AZLRUUeb9YfVHXNMfN02PZJ53qnvHOkocYOsaIJ\n" +
			"vR+5Q7DAb4nxfTZI+ywonBaQvJ/aBT5EL5N21qg03YgrCGvJzJqZd4PL1qYJQgZl\n" +
			"VGAtrRSDKsp+eZ9bNf8lMms1LJyzYlNerBG4yQIDAQABAoIBAQDDxoFOO7gSvzHK\n" +
			"Iyion7nT1IG2zcw4MLWIfjW0QfCn1HTghcTh+TFVLw9hiDW9qjX6YyOW9Hj+FarY\n" +
			"Sgtu2NQka2qPP/awxZ/Cz0NFqnxPd7D24kdcuEGMKyDyiL9S4OBOP2wp3LhDMUjD\n" +
			"wrg2DUxTpPI3Qf5kGieT1qLywvAqpsf/yZx7bM/Dry9uRB6C/2uSf2CAoX0PTy7C\n" +
			"fI1vVuwGHQl1gHG1rlfCAwz5EZ/U+rr52ocptN7ZgNrwPYj4cIL4DPUj71o5enEf\n" +
			"+/Jhz3AogSCjE5hPsRXXCXjFo+n2MBwtuiy1hXASCHDr1ev3mNMrb9JEt3onw8Om\n" +
			"Y2GQ5VXBAoGBAPzYL72ihMpY6gt1R4YtDqcyqYWQCBFKRRjutgT1/qYPkiLJWoJb\n" +
			"Pnolyx813pNTsBwGI+cFVjxH+kua549WtseIX4N8DpOaCoAvXAg7d+Qvf9UTngVI\n" +
			"DkfPa9ON2IdKETGdvHKXVoHA+7LdvY4xfWruqdYqZRQWpfNT7YHaL9PzAoGBANeI\n" +
			"rboR0/JVCaWqBrYRwGrZKo/WXwqFCxNo7X6MPW5oh3KakqoW1Bfb8JLwmojQ7dpA\n" +
			"16H8gpIxeB6WJPXvV+fB+LGxlFTDoBx+F/q5C0EjCm7+XFZlVCyH0jbdHFpAw8qr\n" +
			"vMD+eQgtpAxbs1YGvG5BeeFTsDwAKHKKUxJ9LTtTAoGAefXdsV8/JkuVOUms4m/B\n" +
			"bazmUGKVQaHNiqU6b1IpLvi7yMPPQKm6jTjFrZxSbEYl4J6lmr3cRt+BQA7MOzvc\n" +
			"loqVZ9rjPRdEkWhGwEHPJuYyhxkbU/jZypGmtTjqhPeZK5GmYK/XLmdkAXcsA/aj\n" +
			"RH0ytvdkIjh6e9Cz87rG7zkCgYA7h4ecLdJhSzV36ScjYHHJ0SNdSPNFH4v4l3GJ\n" +
			"E0jgVsSaVbEOg3GfCWM/4m58PWCEeIZWOj0CDeHEaOnad3nLDBsZURfL9aAiXn1X\n" +
			"BYbjPb9i+qQcRK5kAjuAZb+v+dVaA+cFUwOwy5JUy3sT1pZyyWjVYFz7pXuGb0gU\n" +
			"gjhc+wKBgQDAZuxOuGlzMr4HjT55puRENd5HsiDhYsAAzLGCEpECQerNzQIBfOVB\n" +
			"6O6e57DA9h2PVSXN+8ktCIKvv+RUUa2kNoI0g1dhTy+3+88xALK75Jhoeq5OU+ya\n" +
			"ZKhz3JrcHBmVy2/hI2Jj4kcmg8m97N5pSdvweq8dAvsYR2uAdX3Bnw==\n" +
			"-----END RSA PRIVATE KEY-----";

	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1OCOh38tY8tIjSvG9v9D\n" +
			"S0qBk71p1kKoX1yesZu2yDpLYyD7nZZ5b2LDYioY5dXy+LL+jDuZdhs4qzVdAU8v\n" +
			"ODMrIYxcFkZW4wulkWv+nXofmD2y7kLdJ/IOZbUMsI6omf41lz7e518f9kNDC19b\n" +
			"Iu+lmVUbr16UeyIk35vXayOvKju11wuEAQ+RcVjBVqdPA2FQdMAf5AZLRUUeb9Yf\n" +
			"VHXNMfN02PZJ53qnvHOkocYOsaIJvR+5Q7DAb4nxfTZI+ywonBaQvJ/aBT5EL5N2\n" +
			"1qg03YgrCGvJzJqZd4PL1qYJQgZlVGAtrRSDKsp+eZ9bNf8lMms1LJyzYlNerBG4\n" +
			"yQIDAQAB\n" +
			"-----END PUBLIC KEY-----";
}
