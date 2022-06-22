//
//  ViewController.h
//  Printer
//
//  Created by apple on 16/3/21.
//  Copyright © 2016年 Admin. All rights reserved.
//

#import <UIKit/UIKit.h>

@class CBPeripheral, CBCharacteristic;

@interface ViewController : UIViewController


#pragma mark - PosSDKDelegate// Discover the surrounding
- (void)PosdidUpdatePeripheralList:(NSArray *)peripherals RSSIList:(NSArray *)rssiList;
// Connect to the periphery
- (void)PosdidConnectPeripheral:(CBPeripheral *)peripheral;
// Connection failed
- (void)PosdidFailToConnectPeripheral:(CBPeripheral *)peripheral error:(NSError *)error;
// Disconnect
- (void)PosdidDisconnectPeripheral:(CBPeripheral *)peripheral isAutoDisconnect:(BOOL)isAutoDisconnect;
// Send data successfully
- (void)PosdidWriteValueForCharacteristic:(CBCharacteristic *)character error:(NSError *)error;

@end

