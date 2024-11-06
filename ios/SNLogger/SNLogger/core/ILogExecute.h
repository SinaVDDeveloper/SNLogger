//
// Log 执行器抽象
//
//  Created by xiao sun on 2024/10/25.
//

#import <Foundation/Foundation.h>
#import "ILogger.h"
#import "ITag.h"

#ifndef LogExecute_h
#define LogExecute_h

@protocol ILogExecute <NSObject>

- (void) execute:(id<ILogger>) logger tag:(id<ITag>) tag message:(NSString *) message func:(NSString *) func line:(unsigned int) line;

@end

#endif /* LogExecute_h */
