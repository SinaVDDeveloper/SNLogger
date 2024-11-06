//
//  LoganImpl.m
//  SNLogger
//
//  Created by xiao sun on 2024/10/25.
//

#import "LoganImpl.h"

@implementation LoganImpl

- (BOOL)enable
{
    return YES;
}

- (void)execute:(id)tag level:(eSNLogLevel)level message:(NSString *)message
{
    switch (level) {
        case v:
            logan(v, [NSString stringWithFormat:@"%@ -- func:%@, line:%d, message:%@", tag, __func__, __LINE__, message]);
            break;
            
        default:
            break;
    }
    loganFlush();
}

@end
