---
title: OnTech Installation Scheduling API
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - javascript--nodejs: Node.JS
  - ruby: Ruby
  - python: Python
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
highlight_theme: darkula
headingLevel: 2

---

<h1 id="ontech-installation-scheduling-api">OnTech Installation Scheduling API v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

API for OnTech partners to allow customers to schedule in-home installation services for their smarthome products.

Base URLs:

* <a href="http://localhost:8787">http://localhost:8787</a>

<h1 id="ontech-installation-scheduling-api-session">session</h1>

## put__session

> Code samples

```shell
# You can also use wget
curl -X PUT http://localhost:8787/session \
  -H 'Accept: application/json'

```

```http
PUT http://localhost:8787/session HTTP/1.1
Host: localhost:8787
Accept: application/json

```

```javascript
var headers = {
  'Accept':'application/json'

};

$.ajax({
  url: 'http://localhost:8787/session',
  method: 'put',

  headers: headers,
  success: function(data) {
    console.log(JSON.stringify(data));
  }
})

```

```javascript--nodejs
const fetch = require('node-fetch');

const headers = {
  'Accept':'application/json'

};

fetch('http://localhost:8787/session',
{
  method: 'PUT',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.put 'http://localhost:8787/session',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.put('http://localhost:8787/session', params={

}, headers = headers)

print r.json()

```

```java
URL obj = new URL("http://localhost:8787/session");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("PUT", "http://localhost:8787/session", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`PUT /session`

*Create or update a scheduling session*

> Example responses

> 200 Response

```json
{
  "id": "string",
  "expiresAt": "2020-01-01T12:00:00Z",
  "zipcode": "string",
  "reservedTime": {
    "date": "2020-01-27",
    "time": "13:00:00/15:00:00"
  }
}
```

<h3 id="put__session-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|Updated an existing session|[Session](#schemasession)|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|Created a session|[Session](#schemasession)|

<aside class="success">
This operation does not require authentication
</aside>

## get__session_{id}

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8787/session/{id} \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8787/session/{id} HTTP/1.1
Host: localhost:8787
Accept: application/json

```

```javascript
var headers = {
  'Accept':'application/json'

};

$.ajax({
  url: 'http://localhost:8787/session/{id}',
  method: 'get',

  headers: headers,
  success: function(data) {
    console.log(JSON.stringify(data));
  }
})

```

```javascript--nodejs
const fetch = require('node-fetch');

const headers = {
  'Accept':'application/json'

};

fetch('http://localhost:8787/session/{id}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8787/session/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8787/session/{id}', params={

}, headers = headers)

print r.json()

```

```java
URL obj = new URL("http://localhost:8787/session/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8787/session/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /session/{id}`

*Get session details*

<h3 id="get__session_{id}-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|string|true|Session ID|

> Example responses

> 200 Response

```json
{
  "id": "string",
  "expiresAt": "2020-01-01T12:00:00Z",
  "zipcode": "string",
  "reservedTime": {
    "date": "2020-01-27",
    "time": "13:00:00/15:00:00"
  }
}
```

<h3 id="get__session_{id}-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[Session](#schemasession)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Session not found. Either the id is unknown or the session has expired.|None|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="ontech-installation-scheduling-api-services">services</h1>

## get__services

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8787/services \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8787/services HTTP/1.1
Host: localhost:8787
Accept: application/json

```

```javascript
var headers = {
  'Accept':'application/json'

};

$.ajax({
  url: 'http://localhost:8787/services',
  method: 'get',

  headers: headers,
  success: function(data) {
    console.log(JSON.stringify(data));
  }
})

```

```javascript--nodejs
const fetch = require('node-fetch');

const headers = {
  'Accept':'application/json'

};

fetch('http://localhost:8787/services',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8787/services',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8787/services', params={

}, headers = headers)

print r.json()

```

```java
URL obj = new URL("http://localhost:8787/services");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8787/services", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /services`

*Return all OnTech services for partner*

> Example responses

> 200 Response

```json
[
  {
    "id": "string",
    "title": "Smart Thermostat Installation",
    "description": [
      "We install Smart Thermostats",
      "Remove existing thermostat and install smart thermostat",
      "Connect device to existing WiFi network and perform set up",
      "Install and set up mobile app",
      "Teach you how to use the thermostat and app features",
      "Please note: A functioning thermostat is required at the installation area"
    ]
  }
]
```

<h3 id="get__services-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[ServicesList](#schemaserviceslist)|

<aside class="success">
This operation does not require authentication
</aside>

## get__services_{id}

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8787/services/{id} \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8787/services/{id} HTTP/1.1
Host: localhost:8787
Accept: application/json

```

```javascript
var headers = {
  'Accept':'application/json'

};

$.ajax({
  url: 'http://localhost:8787/services/{id}',
  method: 'get',

  headers: headers,
  success: function(data) {
    console.log(JSON.stringify(data));
  }
})

```

```javascript--nodejs
const fetch = require('node-fetch');

const headers = {
  'Accept':'application/json'

};

fetch('http://localhost:8787/services/{id}',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8787/services/{id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8787/services/{id}', params={

}, headers = headers)

print r.json()

```

```java
URL obj = new URL("http://localhost:8787/services/{id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8787/services/{id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /services/{id}`

*Return details for OnTech service*

<h3 id="get__services_{id}-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|id|path|string|true|Service ID|

> Example responses

> 200 Response

```json
{
  "id": "string",
  "title": "Smart Thermostat Installation",
  "description": [
    "We install Smart Thermostats",
    "Remove existing thermostat and install smart thermostat",
    "Connect device to existing WiFi network and perform set up",
    "Install and set up mobile app",
    "Teach you how to use the thermostat and app features",
    "Please note: A functioning thermostat is required at the installation area"
  ]
}
```

<h3 id="get__services_{id}-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[Service](#schemaservice)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Service not found|None|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="ontech-installation-scheduling-api-availability">availability</h1>

## get__availability

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8787/availability?zipcode=90210&productIds=string&startDate=2020-01-27&sessionId=string \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8787/availability?zipcode=90210&productIds=string&startDate=2020-01-27&sessionId=string HTTP/1.1
Host: localhost:8787
Accept: application/json

```

```javascript
var headers = {
  'Accept':'application/json'

};

$.ajax({
  url: 'http://localhost:8787/availability',
  method: 'get',
  data: '?zipcode=90210&productIds=string&startDate=2020-01-27&sessionId=string',
  headers: headers,
  success: function(data) {
    console.log(JSON.stringify(data));
  }
})

```

```javascript--nodejs
const fetch = require('node-fetch');

const headers = {
  'Accept':'application/json'

};

fetch('http://localhost:8787/availability?zipcode=90210&productIds=string&startDate=2020-01-27&sessionId=string',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8787/availability',
  params: {
  'zipcode' => '[Zipcode](#schemazipcode)',
'productIds' => 'array[string]',
'startDate' => '[Date](#schemadate)',
'sessionId' => 'string'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8787/availability', params={
  'zipcode': '90210',  'productIds': [
  "string"
],  'startDate': '2020-01-27',  'sessionId': 'string'
}, headers = headers)

print r.json()

```

```java
URL obj = new URL("http://localhost:8787/availability?zipcode=90210&productIds=string&startDate=2020-01-27&sessionId=string");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8787/availability", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /availability`

*Get availability for zip code, products, and start date*

<h3 id="get__availability-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|zipcode|query|[Zipcode](#schemazipcode)|true|US Zip Code|
|productIds|query|array[string]|true|Product IDs to check installation availability for|
|startDate|query|[Date](#schemadate)|true|First date to check availability. Must be on or after today.|
|sessionId|query|string|true|Customer's OnTech session id|

> Example responses

> 200 Response

```json
{
  "days": [
    {
      "date": "2020-01-27",
      "times": [
        "13:00:00/15:00:00"
      ]
    }
  ],
  "next": "2020-01-27",
  "previous": "2020-01-27",
  "session": {
    "id": "string",
    "expiresAt": "2020-01-01T12:00:00Z",
    "zipcode": "string",
    "reservedTime": {
      "date": "2020-01-27",
      "time": "13:00:00/15:00:00"
    }
  }
}
```

<h3 id="get__availability-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[Availabilities](#schemaavailabilities)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request. Verify parameters are present and valid.|None|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|No availability found|None|

<aside class="success">
This operation does not require authentication
</aside>

## get__availability_first

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8787/availability/first?zipcode=90210&productIds=string&startDate=2020-01-27 \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8787/availability/first?zipcode=90210&productIds=string&startDate=2020-01-27 HTTP/1.1
Host: localhost:8787
Accept: application/json

```

```javascript
var headers = {
  'Accept':'application/json'

};

$.ajax({
  url: 'http://localhost:8787/availability/first',
  method: 'get',
  data: '?zipcode=90210&productIds=string&startDate=2020-01-27',
  headers: headers,
  success: function(data) {
    console.log(JSON.stringify(data));
  }
})

```

```javascript--nodejs
const fetch = require('node-fetch');

const headers = {
  'Accept':'application/json'

};

fetch('http://localhost:8787/availability/first?zipcode=90210&productIds=string&startDate=2020-01-27',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8787/availability/first',
  params: {
  'zipcode' => '[Zipcode](#schemazipcode)',
'productIds' => 'array[string]',
'startDate' => '[Date](#schemadate)'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8787/availability/first', params={
  'zipcode': '90210',  'productIds': [
  "string"
],  'startDate': '2020-01-27'
}, headers = headers)

print r.json()

```

```java
URL obj = new URL("http://localhost:8787/availability/first?zipcode=90210&productIds=string&startDate=2020-01-27");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8787/availability/first", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /availability/first`

*Get next available installation for zip code, products, and start date*

<h3 id="get__availability_first-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|zipcode|query|[Zipcode](#schemazipcode)|true|US Zip Code|
|productIds|query|array[string]|true|Product IDs to check installation availability for|
|startDate|query|[Date](#schemadate)|true|First date to check availability. Must be on or after today.|

> Example responses

> 200 Response

```json
{
  "date": "2020-01-27",
  "time": "13:00:00/15:00:00"
}
```

<h3 id="get__availability_first-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|[AvailableTime](#schemaavailabletime)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request. Verify parameters are present and valid.|None|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|No availability found|None|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="ontech-installation-scheduling-api-order">order</h1>

## post__orders

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8787/orders \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json'

```

```http
POST http://localhost:8787/orders HTTP/1.1
Host: localhost:8787
Content-Type: application/json
Accept: application/json

```

```javascript
var headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'

};

$.ajax({
  url: 'http://localhost:8787/orders',
  method: 'post',

  headers: headers,
  success: function(data) {
    console.log(JSON.stringify(data));
  }
})

```

```javascript--nodejs
const fetch = require('node-fetch');
const inputBody = '{
  "sessionId": "string",
  "services": [
    "string"
  ],
  "products": [
    "string"
  ],
  "installationAddress": {
    "street": "9601 S Meridian Blvd",
    "city": "Engleweood",
    "state": "CO",
    "zipcode": "80112"
  },
  "customer": {
    "name": "Millard Fillmore",
    "phone": "7205007201",
    "email": "charlie.ergen@dish.com"
  },
  "customerPhoneConsentAt": "2020-01-27T13:21:44Z"
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'

};

fetch('http://localhost:8787/orders',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => 'application/json'
}

result = RestClient.post 'http://localhost:8787/orders',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.post('http://localhost:8787/orders', params={

}, headers = headers)

print r.json()

```

```java
URL obj = new URL("http://localhost:8787/orders");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"application/json"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8787/orders", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /orders`

*Create an order*

> Body parameter

```json
{
  "sessionId": "string",
  "services": [
    "string"
  ],
  "products": [
    "string"
  ],
  "installationAddress": {
    "street": "9601 S Meridian Blvd",
    "city": "Engleweood",
    "state": "CO",
    "zipcode": "80112"
  },
  "customer": {
    "name": "Millard Fillmore",
    "phone": "7205007201",
    "email": "charlie.ergen@dish.com"
  },
  "customerPhoneConsentAt": "2020-01-27T13:21:44Z"
}
```

<h3 id="post__orders-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Order](#schemaorder)|true|none|

> Example responses

> 202 Response

```json
{
  "id": "string"
}
```

<h3 id="post__orders-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|202|[Accepted](https://tools.ietf.org/html/rfc7231#section-6.3.3)|Order accepted|[OrderResponse](#schemaorderresponse)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request. Verify session has not expired and all required fields are present and valid.|None|

<aside class="success">
This operation does not require authentication
</aside>

# Schemas

<h2 id="tocSzipcode">Zipcode</h2>

<a id="schemazipcode"></a>

```json
"90210"

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|string(zipcode)|false|none|none|

<h2 id="tocSdate">Date</h2>

<a id="schemadate"></a>

```json
"2020-01-27"

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|string(date)|false|none|none|

<h2 id="tocSservice">Service</h2>

<a id="schemaservice"></a>

```json
{
  "id": "string",
  "title": "Smart Thermostat Installation",
  "description": [
    "We install Smart Thermostats",
    "Remove existing thermostat and install smart thermostat",
    "Connect device to existing WiFi network and perform set up",
    "Install and set up mobile app",
    "Teach you how to use the thermostat and app features",
    "Please note: A functioning thermostat is required at the installation area"
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|string|false|none|none|
|title|string|false|none|Service display title|
|description|[string]|false|none|Service description bullet points|

<h2 id="tocStimeslot">TimeSlot</h2>

<a id="schematimeslot"></a>

```json
"13:00:00/15:00:00"

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|string|false|none|none|

<h2 id="tocSsession">Session</h2>

<a id="schemasession"></a>

```json
{
  "id": "string",
  "expiresAt": "2020-01-01T12:00:00Z",
  "zipcode": "string",
  "reservedTime": {
    "date": "2020-01-27",
    "time": "13:00:00/15:00:00"
  }
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|string|false|none|none|
|expiresAt|string|false|none|Time this session will expire|
|zipcode|any|false|none|none|

*allOf*

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» *anonymous*|[Zipcode](#schemazipcode)|false|none|none|

*and*

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» *anonymous*|any|false|none|none|

*and*

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» *anonymous*|any|false|none|The zipcode to use for installation|

*continued*

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|reservedTime|any|false|none|none|

*allOf*

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» *anonymous*|[AvailableTime](#schemaavailabletime)|false|none|none|

*and*

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|» *anonymous*|any|false|none|none|

<h2 id="tocSserviceslist">ServicesList</h2>

<a id="schemaserviceslist"></a>

```json
[
  {
    "id": "string",
    "title": "Smart Thermostat Installation",
    "description": [
      "We install Smart Thermostats",
      "Remove existing thermostat and install smart thermostat",
      "Connect device to existing WiFi network and perform set up",
      "Install and set up mobile app",
      "Teach you how to use the thermostat and app features",
      "Please note: A functioning thermostat is required at the installation area"
    ]
  }
]

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[Service](#schemaservice)]|false|none|none|

<h2 id="tocSavailabilities">Availabilities</h2>

<a id="schemaavailabilities"></a>

```json
{
  "days": [
    {
      "date": "2020-01-27",
      "times": [
        "13:00:00/15:00:00"
      ]
    }
  ],
  "next": "2020-01-27",
  "previous": "2020-01-27",
  "session": {
    "id": "string",
    "expiresAt": "2020-01-01T12:00:00Z",
    "zipcode": "string",
    "reservedTime": {
      "date": "2020-01-27",
      "time": "13:00:00/15:00:00"
    }
  }
}

```

*Provides a list of days and time slots. Use `next` and `previous` to page through the calendar.*

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|days|[[AvailableDay](#schemaavailableday)]|false|none|none|
|next|[Date](#schemadate)|false|none|none|
|previous|[Date](#schemadate)|false|none|none|
|session|[Session](#schemasession)|false|none|none|

<h2 id="tocSavailableday">AvailableDay</h2>

<a id="schemaavailableday"></a>

```json
{
  "date": "2020-01-27",
  "times": [
    "13:00:00/15:00:00"
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|date|[Date](#schemadate)|false|none|none|
|times|[[TimeSlot](#schematimeslot)]|false|none|none|

<h2 id="tocSavailabletime">AvailableTime</h2>

<a id="schemaavailabletime"></a>

```json
{
  "date": "2020-01-27",
  "time": "13:00:00/15:00:00"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|date|[Date](#schemadate)|false|none|none|
|time|[TimeSlot](#schematimeslot)|false|none|none|

<h2 id="tocSorder">Order</h2>

<a id="schemaorder"></a>

```json
{
  "sessionId": "string",
  "services": [
    "string"
  ],
  "products": [
    "string"
  ],
  "installationAddress": {
    "street": "9601 S Meridian Blvd",
    "city": "Engleweood",
    "state": "CO",
    "zipcode": "80112"
  },
  "customer": {
    "name": "Millard Fillmore",
    "phone": "7205007201",
    "email": "charlie.ergen@dish.com"
  },
  "customerPhoneConsentAt": "2020-01-27T13:21:44Z"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|sessionId|string|false|none|none|
|services|[string]|false|none|none|
|products|[string]|false|none|Names of products being installed|
|installationAddress|[Address](#schemaaddress)|false|none|none|
|customer|[Customer](#schemacustomer)|false|none|none|
|customerPhoneConsentAt|string(timestamp)|false|none|The time the customer consented to phone calls from OnTech|

<h2 id="tocSorderresponse">OrderResponse</h2>

<a id="schemaorderresponse"></a>

```json
{
  "id": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|string|false|none|none|

<h2 id="tocSaddress">Address</h2>

<a id="schemaaddress"></a>

```json
{
  "street": "9601 S Meridian Blvd",
  "city": "Engleweood",
  "state": "CO",
  "zipcode": "80112"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|street|string|false|none|none|
|city|string|false|none|none|
|state|string|false|none|none|
|zipcode|string|false|none|none|

<h2 id="tocScustomer">Customer</h2>

<a id="schemacustomer"></a>

```json
{
  "name": "Millard Fillmore",
  "phone": "7205007201",
  "email": "charlie.ergen@dish.com"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|false|none|none|
|phone|string(phone)|false|none|none|
|email|string(email)|false|none|none|

