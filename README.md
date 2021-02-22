# Pascal VOC performance index comparison
Network|Model Size|mAP(VOC 2017)|FLOPS
:---:|:---:|:---:|:---:
Tiny YOLOv2|60.5MB|57.1%|6.97BFlops
Tiny YOLOv3|33.4MB|58.4%|5.52BFlops
YOLO Nano|4.0MB|69.1%|4.51Bflops
MobileNetv2-SSD-Lite|13.8MB|68.6%|&Bflops
MobileNetV2-YOLOv3|11.52MB|70.20%|2.02Bflos
Pelee-SSD|21.68MB|70.09%|2.40Bflos
***Yolo Fastest***|1.3MB|61.02%|0.23Bflops
***Yolo Fastest-XL***|3.5MB|69.43%|0.70Bflops
***MobileNetv2-Yolo-Lite***|8.0MB|73.26%|1.80Bflops

* Performance indicators reference from the papers and public indicators in the github project
* MobileNetv2-Yolo-Lite: https://github.com/dog-qiuqiu/MobileNet-Yolo#mobilenetv2-yolov3-litenano-darknet
