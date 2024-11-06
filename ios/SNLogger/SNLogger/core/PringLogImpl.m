#import "PringLogImpl.h"

@implementation PringLogImpl

- (BOOL)enable
{
    return YES;
}

- (void) execute:(NSString *) tag level:(eSNLogLevel) level message:(NSString *) message
{
    switch (level) {
        case v:
            NSLog(@"VERBOSE -- %@ message:%@",tag,message);
            break;
        case d:
            NSLog(@"DEBUG -- %@ message:%@",tag,message);
            break;
        case i:
            NSLog(@"INFO -- %@ message:%@",tag,message);
            break;
        case w:
            NSLog(@"WARN -- %@ message:%@",tag,message);
            break;
        case e:
            NSLog(@"ERROR -- %@ message:%@",tag,message);
            break;
        case wtf:
            NSLog(@"WTF -- %@ message:%@",tag,message);
            break;
        default:
            break;
    }
}

@end
