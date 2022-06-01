package _2022_06_01;

import tools.Asserts;

//请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
//
// 请你实现 ParkingSystem 类：
//
//
// ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停
//车位的数目。
// bool addCar(int carType) 检查是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2
// 和 3 表示。一辆车只能停在 carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
//
//
//
//
// 示例 1：
//
//
//输入：
//["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
//[[1, 1, 0], [1], [2], [3], [1]]
//输出：
//[null, true, true, false, false]
//
//解释：
//ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
//parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
//parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
//parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
//parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
//
//
//
//
// 提示：
//
//
// 0 <= big, medium, small <= 1000
// carType 取值为 1， 2 或 3
// 最多会调用 addCar 函数 1000 次
//
// Related Topics 设计 计数 模拟 👍 113 👎 0

public class _1603_ParkingSystem extends Asserts {

	public static void main(String[] args) {
		_1603_ParkingSystem app = new _1603_ParkingSystem();
		ParkingSystem parkingSystem = new ParkingSystem(1,1,0);
		isTrue(parkingSystem.addCar(1));
		isTrue(parkingSystem.addCar(2));
		isFalse(parkingSystem.addCar(3));
		isFalse(parkingSystem.addCar(1));
	}

	static class ParkingSystem {

		public static final int BIG = 1;
		public static final int MEDIUM = 2;
		public static final int SMALL = 3;

		private int big;
		private int medium;
		private int small;

		public ParkingSystem(int big, int medium, int small) {
			this.big = big;
			this.medium = medium;
			this.small = small;
		}

		public boolean addCar(int carType) {
			switch (carType) {
				case BIG:
					return --big < 0 ? false : true;
				case MEDIUM:
					return --medium < 0 ? false : true;
				case SMALL:
					return --small < 0 ? false : true;
				default:
					return false;
			}
		}
	}
}
