const expect = require('chai').expect
const path = require('path')
const chai = require('chai')
const { Pact } = require('@pact-foundation/pact')
const axios = require('axios')

describe('The Cart API', () => {
    let url = 'http://localhost'
    const port = 1234

    const provider = new Pact({
        port: port,
        log: path.resolve(process.cwd(), 'logs', 'mockserver-integration.log'),
        dir: path.resolve(process.cwd(), 'pacts'),
        spec: 2,
        consumer: 'CartJsConsumer',
        provider: 'CartAPI'
    })

    before(async function() { // TODO can when use lambda?
        this.timeout(10000)
        await provider.setup()
    })

    after(async function() {
        this.timeout(10000)
        await provider.finalize()
    })

    describe('POST /session', () => {
        before(done => {
            const interaction = {
                uponReceiving: 'Create a session',
                withRequest: {
                    method: 'POST',
                    path: '/session'
                },
                willRespondWith: {
                    status: 201,
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: {
                        id: "session-id",
                        expiresAt: "2020-01-01T12:00:00Z"
                    }
                }
            }
            provider.addInteraction(interaction).then(() => done())
        })

        afterEach(() => provider.verify())

        it("should return a session id and expiration", (done) => {
            axios.request({
                method: 'POST',
                baseURL: 'http://localhost:1234',
                url: '/session',
                headers: { 'Accept': 'application/json' }
            }).then((resp) => {
                expect(resp.data).to.deep.equal({
                    id: "session-id",
                    expiresAt: "2020-01-01T12:00:00Z"
                })
                done()
            })
        })
    })

    describe('GET /session/{id}', () => {
        before(done => {
            const interaction = {
                uponReceiving: 'Retrieve a session',
                withRequest: {
                    method: 'GET',
                    path: '/session/my-session-id'
                },
                willRespondWith: {
                    status: 201,
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: {
                        id: "my-session-id",
                        expiresAt: "2020-01-01T12:00:00Z"
                    }
                }
            }
            provider.addInteraction(interaction).then(() => done())
        })

        afterEach(() => provider.verify())

        it("should return a session id and expiration", (done) => {
            axios.request({
                method: 'GET',
                baseURL: 'http://localhost:1234',
                url: '/session/my-session-id',
                headers: { 'Accept': 'application/json' }
            }).then((resp) => {
                expect(resp.data).to.deep.equal({
                    id: "my-session-id",
                    expiresAt: "2020-01-01T12:00:00Z"
                })
                done()
            })
        })
    })

    describe('GET /services', () => {
        before(done => {
            const interaction = {
                uponReceiving: 'Get list of services',
                withRequest: {
                    method: 'GET',
                    path: '/services'
                },
                willRespondWith: {
                    status: 200,
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body:
                    [
                        {
                            id: "string",
                            title: "Smart Thermostat Installation",
                            description: [
                                "We install Smart Thermostats",
                                "Remove existing thermostat and install smart thermostat"
                            ]
                        }
                    ]
                }
            }
            provider.addInteraction(interaction).then(()=>done())
        })

        afterEach(() => provider.verify())

        it("should return an array of services", (done) => {
            axios.request({
                method: 'GET',
                baseURL: 'http://localhost:1234',
                url: '/services',
                headers: { 'Accept': 'application/json' }
            }).then((resp) => {
                expect(resp.data).to.deep.equal([{
                     "id": "string",
                      "title": "Smart Thermostat Installation",
                      "description": [
                          "We install Smart Thermostats",
                          "Remove existing thermostat and install smart thermostat"
                      ]
                }])
                done()
            })
        })
    })

    describe('GET /services/{id}', () => {
        before(done => {
            const interaction = {
                uponReceiving: 'Get a single service',
                withRequest: {
                    method: 'GET',
                    path: '/services'
                },
                willRespondWith: {
                    status: 200,
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body:
                    {
                        id: "string",
                        title: "Smart Thermostat Installation",
                        description: [
                            "We install Smart Thermostats",
                            "Remove existing thermostat and install smart thermostat"
                        ]
                    }
                }
            }
            provider.addInteraction(interaction).then(() => done())
        })

        afterEach(() => provider.verify())

        it("should return an array of services", (done) => {
            axios.request({
                method: 'GET',
                baseURL: 'http://localhost:1234',
                url: '/services',
                headers: { 'Accept': 'application/json' }
            }).then((resp) => {
                expect(resp.data).to.deep.equal({
                     "id": "string",
                      "title": "Smart Thermostat Installation",
                      "description": [
                          "We install Smart Thermostats",
                          "Remove existing thermostat and install smart thermostat"
                      ]
                })
                done()
            })
        })
    })

    describe('GET /availability', () => {
        before(done => {
            const interaction = {
                uponReceiving: 'A zipcode',
                withRequest: {
                    method: 'GET',
                    path: '/availability',
                    query: {
                        zipCode: "90210",
                        startDate: "2020-01-27",
                        productIds: "1,2,3",
                        sessionId: "my_session_id"
                    }
                },
                willRespondWith: {
                    status: 200,
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body:
                    {
                        days: [
                            {
                                date: "2020-01-27",
                                times: ["13:00:00/15:00:00"]
                            }
                        ],
                        next: "2020-01-27",
                        previous: "2020-01-27",
                        session: {
                            id: "my_session_id",
                            expiresAt: "2020-01-01T12:00:00Z"
                        }
                    }
                }
            }
            provider.addInteraction(interaction).then(() => done())
        })

        afterEach(() => provider.verify())

        it("should return availability for zipcode", (done) => {
            axios.request({
                method: 'GET',
                baseURL: 'http://localhost:1234',
                url: '/availability?zipCode=90210&startDate=2020-01-27&productIds=1,2,3&sessionId=my_session_id',
                headers: { 'Accept': 'application/json' }
            }).then((resp) => {
                expect(resp.data).to.deep.equal(
                {
                    days: [
                        {
                            date: "2020-01-27",
                            times: ["13:00:00/15:00:00"]
                        }
                    ],
                    next: "2020-01-27",
                    previous: "2020-01-27",
                    session: {
                        id: "my_session_id",
                        expiresAt: "2020-01-01T12:00:00Z"
                    }
                })
                done()
            })
        })
     })
})

function sendRequest(name) {
    return axios.request({
        method: 'GET',
        baseURL: 'http://localhost:1234',
        url: '/api/stuff',
        headers: { 'Accept': 'application/json' }
    })
}