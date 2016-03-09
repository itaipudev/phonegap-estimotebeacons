//
//  OutSystemsAppDelegate+Beacons.h
//  OutSystems
//
//  Created by Danilo Costa on 08/03/16.
//
//

#import "AppDelegate.h"
#import <EstimoteSDK/ESTBeaconManager.h>
#import <objc/runtime.h>

@interface AppDelegate (Beacons) <ESTBeaconManagerDelegate>

@property (strong, nonatomic) ESTBeaconManager *beaconManager;
- (BOOL) xxx_application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions;


@end
