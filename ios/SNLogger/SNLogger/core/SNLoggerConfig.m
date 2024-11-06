#import "SNLoggerConfig.h"

@implementation SNLoggerConfig
static SNLoggerConfig *_sharedInstance = nil;

- (instancetype)init
{
    if(self = [super init])
    {
        self.level = v;
    }
    return self;
}

+ (instancetype)shareInstance
{
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        _sharedInstance = [[self alloc] init];
    });
    return _sharedInstance;
}

@end
