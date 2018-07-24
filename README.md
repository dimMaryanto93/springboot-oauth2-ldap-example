# Security Oauth2 with LDAP

## Request token

```bash
curl -X POST \
  'http://localhost:8080/oauth/token?grant_type=password&username=user&password=password&client_id=mandiri_mits' \
  -H 'Authorization: Basic bWFuZGlyaV9taXRzOjEyMzQ1Ng=='
```