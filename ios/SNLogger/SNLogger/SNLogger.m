#import "SNLogger.h"
#import "core/impl/LogEXED.h"
#import "core/impl/LogEXEI.h"
#import "core/impl/LogEXEV.h"
#import "core/impl/LogEXEW.h"
#import "core/impl/LogEXEE.h"
#import "core/impl/LogEXEWTF.h"
#import "core/SNLoggerConfig.h"
#import "core/SNLogTag.h"

@interface SNLogger()

@property(nonatomic,strong) LogEXED *logD;
@property(nonatomic,strong) LogEXEI *logI;
@property(nonatomic,strong) LogEXEV *logV;
@property(nonatomic,strong) LogEXEW *logW;
@property(nonatomic,strong) LogEXEE *logE;
@property(nonatomic,strong) LogEXEWTF *logWTF;
@property(nonatomic,strong) NSMutableArray *sLogList;

- (void) log:(id<ILogExecute>) logExecute tag:(id<ITag>) tag func:(NSString *) func line:(unsigned int) line;

@end

@implementation SNLogger
static SNLogger *_sharedInstance = nil;

- (instancetype)init
{
    if(self = [super init])
    {
        self.sLogList = [NSMutableArray arrayWithCapacity:1];
    }
    return self;
}

- (void)addLogImpl:(id<ILogger>)logger
{
    if(logger)
    {
        [self.sLogList addObject:logger];
    }
}

- (void)setup
{
    
}

- (void)level:(eSNLogLevel)level
{
    [SNLoggerConfig shareInstance].level = level;
}

- (void)log:(id<ILogExecute>)logExecute tag:(id<ITag>)tag func:(NSString *)func line:(unsigned int)line
{
    logExecute execute:<#(id<ILogger>)#> tag:<#(id<ITag>)#> message:<#(NSString *)#> func:<#(NSString *)#> line:<#(unsigned int)#>
}

- (void)d:(nonnull NSString *)message
{
    SNLogTag *tag = [[SNLogTag alloc] init];
    [self log:self.logD tag:tag func:@"" line:0];
}

- (void)d:(nonnull NSString *)message tag:(id<ITag>)tag
{
    [self log:self.logD tag:tag func:@"" line:0];
}

- (void)d:(nonnull NSString *)message tag:(id<ITag>)tag func:(NSString *)func line:(int)line
{
    [self log:self.logD tag:tag func:func line:line];
}

- (void)i:(NSString *)message
{
    
}

- (void)i:(NSString *)message tag:(id<ITag>)tag
{
    
}

- (void)i:(NSString *)message tag:(id<ITag>)tag func:(NSString *)func line:(int)line
{
    
}

- (void)v:(NSString *)message
{
    
}

- (void)v:(NSString *)message tag:(id<ITag>)tag
{
    
}

- (void)v:(NSString *)message tag:(id<ITag>)tag func:(NSString *)func line:(int)line
{
    
}

- (void)w:(NSString *)message
{
    
}

- (void)w:(NSString *)message tag:(id<ITag>)tag
{
    
}

- (void)w:(NSString *)message tag:(id<ITag>)tag func:(NSString *)func line:(int)line
{
    
}

- (void)e:(NSString *)message
{
    
}

- (void)e:(NSString *)message tag:(id<ITag>)tag
{
    
}

- (void)e:(NSString *)message tag:(id<ITag>)tag func:(NSString *)func line:(int)line
{
    
}

- (void)wtf:(NSString *)message
{
    
}

- (void)wtf:(NSString *)message tag:(id<ITag>)tag
{
    
}

- (void)wtf:(NSString *)message tag:(id<ITag>)tag func:(NSString *)func line:(int)line
{
    
}

+(instancetype) shareInstance
{
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        _sharedInstance = [[self alloc] init];
    });
    
    return _sharedInstance;
}

@end
