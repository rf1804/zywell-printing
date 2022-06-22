//
//  SwiftViewController.swift
//  Printer
//
//  Created by ding on 2021/4/26.
//  Copyright © 2021 Admin. All rights reserved.
//

import UIKit

class SwiftViewController: UIViewController,POSWIFIManagerDelegate {
    @IBOutlet weak var PrintButton: UIButton!
    var wifiManager = POSWIFIManager.share();
    @objc func connect() -> Void {
        // 先断开原来的连接
        wifiManager?.posDisConnect();
        wifiManager?.posConnect(withHost: "192.168.1.200", port: 9100, completion: { (isConnect) in
        })
        
    }
    
    func printLabelData() {
        var dataM = Data()
        var data = Data()
        //  data=[self.codeTextField.text dataUsingEncoding:NSASCIIStringEncoding];
        data = TscCommand.sizeBymm(withWidth: 75, andHeight: 30)
        dataM.append(data)
        data = TscCommand.gapBymm(withWidth: 3, andHeight: 0)
        dataM.append(data)
        data = TscCommand.cls()
        dataM.append(data)
        data = TscCommand.textWith(x: 0, andY: 0, andFont: "TSS24.BF2", andRotation: 0, andX_mul: 1, andY_mul: 1, andContent: "12345678abcd", usStrEnCoding: String.Encoding.ascii.rawValue)
        dataM.append(data)
        data = TscCommand.print(1)
        dataM.append(data)
          wifiManager?.posWriteCommand(with: dataM)
      }
    
    @IBAction func Print(_ sender: Any) {
        printLabelData();
//        let data = Data("hello\n".utf8);
//        wifiManager?.posWriteCommand(with: data);
    }
    override func viewDidLoad() {
        connect();
    }
    func poswifiManager(_ manager: POSWIFIManager!, didConnectedToHost host: String!, port: UInt16) {

    }

    func poswifiManager(_ manager: POSWIFIManager!, willDisconnectWithError error: Error!) {

    }

    func poswifiManager(_ manager: POSWIFIManager!, didWriteDataWithTag tag: Int) {

    }

    func poswifiManager(_ manager: POSWIFIManager!, didRead data: Data!, tag: Int) {
       
    }

    func poswifiManagerDidDisconnected(_ manager: POSWIFIManager!) {

    }
    
}
