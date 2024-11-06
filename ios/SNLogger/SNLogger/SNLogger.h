//
//  SNLogger主入口
//
//  Created by xiao sun on 2024/10/24.
//

#import <Foundation/Foundation.h>
#import "core/ILogger.h"
#import "core/ITag.h"
#import "core/SNLoggerLevel.h"
#import "core/ILogExecute.h"

NS_ASSUME_NONNULL_BEGIN

#define TAG @"SNLogger"

@interface SNLogger : NSObject

- (void) addLogImpl:(id<ILogger>) logger;
- (void) setup;
- (void) level:(eSNLogLevel) level;

- (void) d:(NSString *) message;
- (void) d:(NSString *) message tag:(id<ITag>) tag;
- (void) d:(NSString *) message tag:(id<ITag>) tag func:(NSString *) func line:(int) line;

- (void) i:(NSString *) message;
- (void) i:(NSString *) message tag:(id<ITag>) tag;
- (void) i:(NSString *) message tag:(id<ITag>) tag func:(NSString *) func line:(int) line;


- (void) v:(NSString *) message;
- (void) v:(NSString *) message tag:(id<ITag>) tag;
- (void) v:(NSString *) message tag:(id<ITag>) tag func:(NSString *) func line:(int) line;


- (void) w:(NSString *) message;
- (void) w:(NSString *) message tag:(id<ITag>) tag;
- (void) w:(NSString *) message tag:(id<ITag>) tag func:(NSString *) func line:(int) line;

- (void) e:(NSString *) message;
- (void) e:(NSString *) message tag:(id<ITag>) tag;
- (void) e:(NSString *) message tag:(id<ITag>) tag func:(NSString *) func line:(int) line;

- (void) wtf:(NSString *) message;
- (void) wtf:(NSString *) message tag:(id<ITag>) tag;
- (void) wtf:(NSString *) message tag:(id<ITag>) tag func:(NSString *) func line:(int) line;

+ (instancetype) shareInstance;

@end

NS_ASSUME_NONNULL_END
