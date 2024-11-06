//
//  ViewController.m
//  SNLogger
//
//  Created by xiao sun on 2024/10/20.
//

#import "ViewController.h"
#import "SNLogger/SNLogger.h"


@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    [[SNLogger shareInstance] d:@"TEST MESSAGE!"];
}


@end
