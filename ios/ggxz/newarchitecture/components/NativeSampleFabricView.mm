//
//  NativeSampleFabricView.m
//  ggxz
//
//  Created by 高昇 on 2022/4/18.
//
#import "NativeSampleFabricView.h"

#import <react/renderer/components/NativeSampleFabricViewSpec/Props.h>
#import <react/renderer/components/NativeSampleFabricViewSpec/RCTComponentViewHelpers.h>
#import <react/renderer/components/NativeSampleFabricViewSpec/ComponentDescriptors.h>
#import "RCTFabricComponentsPlugins.h"

using namespace facebook::react;

@interface NativeSampleFabricView () <RCTNativeSampleFabricViewViewProtocol>
@end

@implementation NativeSampleFabricView {
  UITextView *_view;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<NativeSampleFabricViewComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
    if (self = [super initWithFrame:frame]) {
        static const auto defaultProps = std::make_shared<const NativeSampleFabricViewProps>();
        _props = defaultProps;

        _view = [[UITextView alloc] init];

        self.contentView = _view;
    }

    return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<NativeSampleFabricViewProps const>(_props);
    const auto &newViewProps = *std::static_pointer_cast<NativeSampleFabricViewProps const>(props);

    [super updateProps:props oldProps:oldProps];
}

@end

Class<RCTNativeSampleFabricViewViewProtocol> MapViewCls(void)
{
    return NativeSampleFabricView.class;
}
