//
//  AppDelegate.m
//  SNLogger
//
//  Created by xiao sun on 2024/10/20.
//

#import "AppDelegate.h"
#import "SNLogger/SNLogger.h"
#import "LoganImpl.h"

@interface AppDelegate ()

@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    [[SNLogger shareInstance] setup];
    LoganImpl *loganImpl = [[LoganImpl alloc] init];
    [[SNLogger shareInstance] addLogImpl:loganImpl];
    return YES;
}


#pragma mark - UISceneSession lifecycle


- (UISceneConfiguration *)application:(UIApplication *)application configurationForConnectingSceneSession:(UISceneSession *)connectingSceneSession options:(UISceneConnectionOptions *)options {
    return [[UISceneConfiguration alloc] initWithName:@"Default Configuration" sessionRole:connectingSceneSession.role];
}


- (void)application:(UIApplication *)application didDiscardSceneSessions:(NSSet<UISceneSession *> *)sceneSessions {
}


@end
