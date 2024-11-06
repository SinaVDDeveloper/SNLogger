//
//  配置类
//

#import <Foundation/Foundation.h>
#import "SNLoggerLevel.h"

NS_ASSUME_NONNULL_BEGIN

@interface SNLoggerConfig : NSObject

@property (nonatomic,assign) eSNLogLevel level;

+ (instancetype) shareInstance;

@end

NS_ASSUME_NONNULL_END
