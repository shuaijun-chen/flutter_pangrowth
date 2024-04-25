//
//  PlayletPlugin.m
//  flutter_pangrowth
//
//  Created by gstory on 2023/10/10.
//

#import "PlayletPlugin.h"
#import "PangrowthDJX/DJXPlayletAggregatePageViewController.h"
#import "PangrowthDJX/DJXPlayletConfig.h"
#import "PangrowthDJX/DJXManager.h"
#import "PangrowthDJX/DJXConfig.h"


@implementation PlayletPlugin

+ (void)registerPlayletVideo:(NSDictionary *)dic result:(FlutterResult)result{
    DJXConfig *config = [DJXConfig new];
    NSString *configPath = [[NSBundle mainBundle] pathForResource:@"pangrowthconfig" ofType:@"json"];
    [DJXManager initializeWithConfigPath:configPath config:config];
    // 正在初始化，可在进入实际场景前使用
    [DJXManager startWithCompleteHandler:^(DJXINITStatus initStatus, NSDictionary *userInfo) {
        if (initStatus == DJXINITStatus_success) {
            NSLog(@"初始化注册成功！");
            result(@YES);
        } else {
            NSLog(@"初始化注册失败！");
            NSLog(@"%@", userInfo[@"msg"]);
            result(@NO);
        }
    }];
}

# pragma mark - 打开短剧聚合页
+(void)openPlayletAggregatePage:(NSDictionary*)arguments{
    NSDictionary *dic = arguments;
    NSLog(@"短剧聚合页%@",dic);
    NSInteger freeCount = [dic[@"freeCount"] intValue];
    NSInteger unlockCountUsingAD = [dic[@"unlockCountUsingAD"] intValue];
    BOOL isShowTitle = [dic[@"isShowTitle"] boolValue];
    BOOL isShowBackButton = [dic[@"isShowBackButton"] boolValue];
    UINavigationController *viewController =[UIApplication sharedApplication].keyWindow.rootViewController;
    DJXPlayletAggregatePageViewController *vc = [[DJXPlayletAggregatePageViewController alloc] initWithConfigBuilder:^(DJXPlayletAggregatePageVCConfig * _Nonnull config) {
        DJXPlayletConfig *playletConfig = [DJXPlayletConfig new];
        playletConfig.freeEpisodesCount = freeCount;
        playletConfig.unlockEpisodesCountUsingAD = unlockCountUsingAD;
        playletConfig.playletUnlockADMode = DJXPlayletUnlockADMode_Common;
        config.playletConfig = playletConfig;
        config.isShowNavigationItemTitle = isShowTitle;
        config.isShowNavigationItemBackButton = isShowBackButton;
    }];
    [viewController presentViewController:vc animated:YES completion:^{}];
}
//
//# pragma mark - 打开短剧混排
//+(void)openPlayletDrawVideoPage:(NSDictionary*)arguments{
//    NSDictionary *dic = arguments;
//    NSLog(@"短剧混排%@",dic);
//    NSInteger freeCount = [dic[@"freeCount"] intValue];
//    NSInteger unlockCountUsingAD = [dic[@"unlockCountUsingAD"] intValue];
//    BOOL isShowTitle = [dic[@"isShowTitle"] boolValue];
//    BOOL isShowBackButton = [dic[@"isShowBackButton"] boolValue];
//    BOOL isVideoPlaylet = [dic[@"isVideoPlaylet"] boolValue];
//    NSInteger playletFreeCount = [dic[@"playletFreeCount"] intValue];
//    NSInteger topSkitId = [dic[@"topSkitId"] intValue];
//    UINavigationController *viewController =[UIApplication sharedApplication].keyWindow.rootViewController;
//    // LCDDrawVideoViewController
//    DJXPlayletAggregatePageViewController *vc = [[DJXPlayletAggregatePageViewController alloc] initWithConfigBuilder:^(DJXPlayletAggregatePageVCConfig * _Nonnull config) {
//        DJXPlayletConfig *playletConfig = [DJXPlayletConfig new];
//        playletConfig.playletUnlockADMode = DJXPlayletUnlockADMode_Common;
//        //免费观看的集数n
//        playletConfig.freeEpisodesCount = freeCount;
//        //观看一次激励视频解锁的集数m
//        playletConfig.unlockEpisodesCountUsingAD = unlockCountUsingAD;
//        //入口信息
//        // playletConfig.entranceType = LCDPlayletEntranceTypeSkitMixed;
//        config.playletConfig = playletConfig;
//        //是否短视频、短剧混排
////        config.drawVCTabOptions = (isVideoPlaylet ? LCDDrawVideoVCTabOptions_playlet_mixed : LCDDrawVideoVCTabOptions_playlet_feed) | LCDDrawVideoVCTabOptions_theater;
//        // 是否展示导航栏标题名称
//        config.isShowNavigationItemTitle =isShowTitle;
//        //config.shouldHideTabBarView =isShowTitle;
//        //是否需要展示左上角的关闭按钮
//        config.isShowNavigationItemBackButton=isShowBackButton;
//        //config.showCloseButton = isShowBackButton;
//        // 短剧混排流中的免费短剧集数，默认为1集混排
//        // config.playletFreeCount = playletFreeCount;
//        // 短剧混排流中要第一部展现的短剧id
//        // config.topSkitId = topSkitId;
//    }];
//    //    [vc setUserInformationsWithAge:[LCDSurveyUserAge indexSet] Gender:LCDSurveyUserGender.]
//    vc.modalPresentationStyle = UIModalPresentationFullScreen;
//    [viewController presentViewController:vc animated:YES completion:^{}];
//}

//# pragma mark - 打开短剧搜索
//+(void)openPlayletSearchPage:(NSDictionary *)arguments{
//    UINavigationController *viewController =[UIApplication sharedApplication].keyWindow.rootViewController;
//    // DJXPlayletAggregatePageViewController
//    DJXPlayletAggregatePageViewController *vc = [[DJXPlayletAggregatePageViewController alloc] init];
//    vc.modalPresentationStyle = UIModalPresentationFullScreen;
//    [viewController presentViewController:vc animated:NO completion:nil];
//}

@end
