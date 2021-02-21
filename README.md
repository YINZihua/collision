# Evaluating indicator/Benchmark
Network|VOC mAP(0.5)|COCO mAP(0.5)|Resolution|Run Time(Ncnn 1xCore)|Run Time(Ncnn 4xCore)|FLOPS|Weight size
:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:	:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:
[MobileNetV2-YOLOv3-Nano](https://github.com/dog-qiuqiu/MobileNetv2-YOLOV3/tree/master/MobileNetV2-YOLOv3-Nano)|65.27|30.13|320|11.36ms|5.48ms|0.55BFlops|3.0MB	
[MobileNetV2-YOLOv3-Nano](https://github.com/dog-qiuqiu/MobileNetv2-YOLOV3/tree/master/MobileNetV2-YOLOv3-Nano)|65.27|30.13|320|11.36ms|5.48ms|0.55BFlops|3.0MB
[Yolo-Fastest(our)](https://github.com/dog-qiuqiu/Yolo-Fastest/tree/master/Yolo-Fastest)|61.02|&|320|6.74ms|4.42ms|0.23BFlops|1.3MB	[Yolo-Fastest(our)](https://github.com/dog-qiuqiu/Yolo-Fastest/tree/master/Yolo-Fastest)|61.02|23.65|320|6.74ms|4.42ms|0.23BFlops|1.3MB
[Yolo-Fastest-XL(our)](https://github.com/dog-qiuqiu/Yolo-Fastest/tree/master/Yolo-Fastest)|69.43|32.45|320|15.15ms|7.09ms|0.70BFlops|3.5MB	[Yolo-Fastest-XL(our)](https://github.com/dog-qiuqiu/Yolo-Fastest/tree/master/Yolo-Fastest)|69.43|32.45|320|15.15ms|7.09ms|0.70BFlops|3.5MB
* ***Test platform Kirin 990 CPU，Based on [NCNN](https://github.com/Tencent/ncnn)***	* ***Test platform Kirin 990 CPU，Based on [NCNN](https://github.com/Tencent/ncnn)***
* Suitable for hardware with extremely tight computing resources	* Suitable for hardware with extremely tight computing resources


# Evaluating indicator/Benchmark
Network|COCO mAP(0.5)|Resolution|Run Time(Ncnn 1xCore)|Run Time(Ncnn 4xCore)|FLOPS|Params|Weight size
:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:
[MobileNetV2-YOLOv3-Nano](https://github.com/dog-qiuqiu/MobileNetv2-YOLOV3/tree/master/MobileNetV2-YOLOv3-Nano)|65.27|30.13|320|11.36ms|5.48ms|0.55BFlops|3.0M
[Yolo-Fastest](https://github.com/dog-qiuqiu/Yolo-Fastest/tree/master/Yolo-Fastest)|23.65|320X320|6.74ms|4.42ms|0.23BFlops|0.325M|1.3M
[Yolo-Fastest-XL](https://github.com/dog-qiuqiu/Yolo-Fastest/tree/master/Yolo-Fastest)|32.45|320X320|15.15ms|7.09ms|0.70BFlops|0.875M|3.5M
* ***Test platform Kirin 990 CPU，Based on [NCNN](https://github.com/Tencent/ncnn)***
* COCO 2017 Val mAP
* Suitable for hardware with extremely tight computing resources
* This model is recommended to do some simple single object detection suitable for simple application scenarios
