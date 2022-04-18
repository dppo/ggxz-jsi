//
//  NativeSampleFabricViewManager.m
//  ggxz
//
//  Created by 高昇 on 2022/4/18.
//

#import <React/RCTViewManager.h>

@interface NativeSampleFabricViewManager : RCTViewManager
@end

@implementation NativeSampleFabricViewManager

RCT_EXPORT_MODULE(NativeSampleFabricView)
RCT_EXPORT_VIEW_PROPERTY(color, NSString)
RCT_EXPORT_VIEW_PROPERTY(step, int)

- (UIView *)view
{
  return [[UITextView alloc] init];
}

@end
