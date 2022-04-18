//
//  NativeSampleTurboModule.m
//  ggxz
//
//  Created by 高昇 on 2022/4/18.
//

#import "NativeSampleTurboModule.h"

@implementation NativeSampleTurboModule

RCT_EXPORT_MODULE()

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const facebook::react::ObjCTurboModule::InitParams &)params
{
  return std::make_shared<facebook::react::NativeSampleTurboModuleSpecJSI>(params);
}

- (void)asyncOne
{
  
}

- (NSNumber *)syncOne
{
  return [NSNumber numberWithInt:0];
}

@end
