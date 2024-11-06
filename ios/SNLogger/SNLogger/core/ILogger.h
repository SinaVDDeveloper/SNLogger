//
//  Logger 基础类
//
//  Created by xiao sun on 2024/10/25.
//

#import <Foundation/Foundation.h>
#import "SNLoggerLevel.h"

NS_ASSUME_NONNULL_BEGIN

@protocol ILogger <NSObject>

- (BOOL) enable;
- (void) execute:(NSString *) tag level:(eSNLogLevel) level message:(NSString *) message;

@end

NS_ASSUME_NONNULL_END
