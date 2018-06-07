//
//  TestKeys.swift
//  JavaAuthTests
//
//  Created by Nate Armstrong on 6/7/18.
//  Copyright © 2018 Instructure, Inc. All rights reserved.
//

import Foundation

func resourceString(_ path: String) -> String {
    let file = URL(fileURLWithPath: path)
    let data = try! Data(contentsOf: file)
    return String(data: data, encoding: .utf8)!
}

let bundle = Bundle(identifier: "com.instructure.JavaAuth")!

struct Certs {
    static var trustCertCollection: String {
        let path = bundle.path(forResource: "ca", ofType: "crt")!
        return resourceString(path)
    }

    static var clientCertChain: String {
        let path = bundle.path(forResource: "client", ofType: "crt")!
        return resourceString(path)
    }

    static var clientPrivateKey: String {
        let path = bundle.path(forResource: "client", ofType: "pem")!
        return resourceString(path)
    }

    static var certChain: String {
        let path = bundle.path(forResource: "server", ofType: "crt")!
        return resourceString(path)
    }

    static var privateKey: String {
        let path = bundle.path(forResource: "server", ofType: "pem")!
        return resourceString(path)
    }
}
