/*
 * Copyright 2018, gRPC Authors All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import Dispatch
import Foundation
@testable import JavaAuth
import XCTest

enum Security {
  case regular, none
}

class BasicEchoTestCase: XCTestCase {
  var client: Echo_EchoServiceClient!

  var defaultTimeout: TimeInterval { return 1.0 }
  // requires example.com to redirect to 127.0.0.1 in /etc/hosts
  var address: String { return "example.com:50051" }

  // requires deployed server on Google cloud endpoints / kubernetes engine
  var gcloudURI: String { return "echo.endpoints.delta-essence-114723.cloud.goog" }
  var gcloudAddress: String { return "\(gcloudURI):80" }
  let certificate = Certs.trustCertCollection
  let clientCertificate = Certs.clientCertChain
  let clientKey = Certs.clientPrivateKey

  override func setUp() {
    super.setUp()
  }

  func testRegularSSL() {
    client = Echo_EchoServiceClient(address: address, certificates: certificate, arguments: [.sslTargetNameOverride("example.com")])
    client.host = "example.com"
    client.timeout = defaultTimeout

    XCTAssertEqual("hi", try! client.get(Echo_EchoRequest(text: "hi")).text)
  }

  func testTLSMutualAuth() {
    client = Echo_EchoServiceClient(address: address, certificates: certificate, clientCertificates: clientCertificate, clientKey: clientKey, arguments: [.sslTargetNameOverride("example.com")])
    client.host = "example.com"
    client.timeout = defaultTimeout

    XCTAssertEqual("hi", try! client.get(Echo_EchoRequest(text: "hi")).text)
  }

  func testTLSMutualAuthGcloud() {
    client = Echo_EchoServiceClient(address: gcloudAddress, certificates: certificate, clientCertificates: clientCertificate, clientKey: clientKey, arguments: [.sslTargetNameOverride("example.com")])
    client.host = gcloudURI
    client.timeout = defaultTimeout

    XCTAssertEqual("hi", try! client.get(Echo_EchoRequest(text: "hi")).text)
  }

  override func tearDown() {
    client = nil

    super.tearDown()
  }
}
