package colormap;

import java.awt.Color;

// This Java code defines a class called ColorMap, which is used to generate color maps.
// This class provides three color mapping modes: sea, land and parula.
// These colormaps are used to represent oceans, land, and a special colormap

public class ColorMap {
	private int[] cmap_sea;
	private int[] cmap_land;
	private int[] cmap;
	private int length;
	private double zmin;
	private double zmax;
	public int deep_sea = new Color(12, 25, 38).getRGB();

	public ColorMap(double zmin_init, double zmax_init) {
		zmin = zmin_init;
		zmax = zmax_init;
		cmap_sea = null;
		cmap_land = null;
		cmap = null;
	}

	public void sea(int n) {
		length = n;
		cmap_sea = new int[n];
		for (int i = 0; i < n; i++) {
			double x = 1.0 * i / (n - 1);
			x = 0.3 * x * x + 0.7 * x;
			double start = 0.15;
			double body = ((1 - start) / 2 * (Math.sin(Math.PI * (x - 0.5)) + 1) + start) * 255;
			int B = (int) body;
			int G = (int) (2.0 / 3 * body);
			int R = (int) (1.0 / 3 * body);
			cmap_sea[i] = new Color(R, G, B).getRGB();
		}
		cmap = cmap_sea;
	}

	public void land(int n) {
		length = n;
		double[][] C = { { 0, 0.4, 0.2 },
				{ 0.0025393, 0.40471, 0.20047 },
				{ 0.0051377, 0.40941, 0.20093 },
				{ 0.0077952, 0.41412, 0.2014 },
				{ 0.010512, 0.41882, 0.20186 },
				{ 0.013287, 0.42353, 0.20232 },
				{ 0.016122, 0.42824, 0.20278 },
				{ 0.019015, 0.43294, 0.20325 },
				{ 0.021968, 0.43765, 0.20373 },
				{ 0.02498, 0.44235, 0.2042 },
				{ 0.028051, 0.44706, 0.20469 },
				{ 0.031181, 0.45176, 0.20519 },
				{ 0.03437, 0.45647, 0.20569 },
				{ 0.037618, 0.46118, 0.20621 },
				{ 0.040925, 0.46588, 0.20674 },
				{ 0.044291, 0.47059, 0.20729 },
				{ 0.047716, 0.47529, 0.20785 },
				{ 0.0512, 0.48, 0.20843 },
				{ 0.054743, 0.48471, 0.20902 },
				{ 0.058346, 0.48941, 0.20964 },
				{ 0.062007, 0.49412, 0.21028 },
				{ 0.065727, 0.49882, 0.21094 },
				{ 0.069507, 0.50353, 0.21163 },
				{ 0.073345, 0.50824, 0.21234 },
				{ 0.077243, 0.51294, 0.21308 },
				{ 0.0812, 0.51765, 0.21385 },
				{ 0.085215, 0.52235, 0.21464 },
				{ 0.08929, 0.52706, 0.21547 },
				{ 0.093424, 0.53176, 0.21633 },
				{ 0.097617, 0.53647, 0.21723 },
				{ 0.10187, 0.54118, 0.21816 },
				{ 0.10618, 0.54588, 0.21912 },
				{ 0.11055, 0.55059, 0.22013 },
				{ 0.11498, 0.55529, 0.22117 },
				{ 0.11947, 0.56, 0.22226 },
				{ 0.12401, 0.56471, 0.22339 },
				{ 0.12862, 0.56941, 0.22456 },
				{ 0.13329, 0.57412, 0.22577 },
				{ 0.13801, 0.57882, 0.22704 },
				{ 0.14279, 0.58353, 0.22835 },
				{ 0.14764, 0.58824, 0.22971 },
				{ 0.15254, 0.59294, 0.23112 },
				{ 0.1575, 0.59765, 0.23258 },
				{ 0.16252, 0.60235, 0.2341 },
				{ 0.1676, 0.60706, 0.23567 },
				{ 0.17273, 0.61176, 0.2373 },
				{ 0.17793, 0.61647, 0.23898 },
				{ 0.18319, 0.62118, 0.24073 },
				{ 0.1885, 0.62588, 0.24253 },
				{ 0.19387, 0.63059, 0.2444 },
				{ 0.19931, 0.63529, 0.24633 },
				{ 0.2048, 0.64, 0.24832 },
				{ 0.21035, 0.64471, 0.25038 },
				{ 0.21596, 0.64941, 0.25251 },
				{ 0.22163, 0.65412, 0.2547 },
				{ 0.22736, 0.65882, 0.25697 },
				{ 0.23315, 0.66353, 0.25931 },
				{ 0.23899, 0.66824, 0.26172 },
				{ 0.2449, 0.67294, 0.2642 },
				{ 0.25086, 0.67765, 0.26676 },
				{ 0.25689, 0.68235, 0.2694 },
				{ 0.26297, 0.68706, 0.27212 },
				{ 0.26911, 0.69176, 0.27491 },
				{ 0.27531, 0.69647, 0.27779 },
				{ 0.28239, 0.70118, 0.28157 },
				{ 0.29199, 0.70588, 0.28789 },
				{ 0.30161, 0.71059, 0.29427 },
				{ 0.31127, 0.71529, 0.3007 },
				{ 0.32096, 0.72, 0.3072 },
				{ 0.33068, 0.72471, 0.31376 },
				{ 0.34042, 0.72941, 0.32037 },
				{ 0.35019, 0.73412, 0.32704 },
				{ 0.35998, 0.73882, 0.33377 },
				{ 0.3698, 0.74353, 0.34057 },
				{ 0.37964, 0.74824, 0.34742 },
				{ 0.3895, 0.75294, 0.35433 },
				{ 0.39937, 0.75765, 0.36129 },
				{ 0.40927, 0.76235, 0.36832 },
				{ 0.41918, 0.76706, 0.37541 },
				{ 0.42911, 0.77176, 0.38255 },
				{ 0.43904, 0.77647, 0.38976 },
				{ 0.449, 0.78118, 0.39702 },
				{ 0.45896, 0.78588, 0.40434 },
				{ 0.46893, 0.79059, 0.41173 },
				{ 0.4789, 0.79529, 0.41917 },
				{ 0.48889, 0.8, 0.42667 },
				{ 0.49888, 0.80471, 0.43423 },
				{ 0.50887, 0.80941, 0.44184 },
				{ 0.51887, 0.81412, 0.44952 },
				{ 0.52886, 0.81882, 0.45726 },
				{ 0.53886, 0.82353, 0.46505 },
				{ 0.54885, 0.82824, 0.47291 },
				{ 0.55884, 0.83294, 0.48082 },
				{ 0.56882, 0.83765, 0.48879 },
				{ 0.5788, 0.84235, 0.49682 },
				{ 0.58877, 0.84706, 0.50491 },
				{ 0.59873, 0.85176, 0.51306 },
				{ 0.60869, 0.85647, 0.52127 },
				{ 0.61863, 0.86118, 0.52954 },
				{ 0.62855, 0.86588, 0.53787 },
				{ 0.63846, 0.87059, 0.54625 },
				{ 0.64836, 0.87529, 0.5547 },
				{ 0.65824, 0.88, 0.5632 },
				{ 0.6681, 0.88471, 0.57176 },
				{ 0.67794, 0.88941, 0.58038 },
				{ 0.68776, 0.89412, 0.58907 },
				{ 0.69755, 0.89882, 0.59781 },
				{ 0.70733, 0.90353, 0.6066 },
				{ 0.71707, 0.90824, 0.61546 },
				{ 0.72679, 0.91294, 0.62438 },
				{ 0.73648, 0.91765, 0.63336 },
				{ 0.74614, 0.92235, 0.64239 },
				{ 0.75577, 0.92706, 0.65149 },
				{ 0.76537, 0.93176, 0.66064 },
				{ 0.77493, 0.93647, 0.66985 },
				{ 0.78446, 0.94118, 0.67912 },
				{ 0.79395, 0.94588, 0.68845 },
				{ 0.8034, 0.95059, 0.69784 },
				{ 0.81281, 0.95529, 0.70729 },
				{ 0.82219, 0.96, 0.7168 },
				{ 0.83152, 0.96471, 0.72637 },
				{ 0.8408, 0.96941, 0.73599 },
				{ 0.85004, 0.97412, 0.74568 },
				{ 0.85924, 0.97882, 0.75542 },
				{ 0.86838, 0.98353, 0.76522 },
				{ 0.87748, 0.98824, 0.77509 },
				{ 0.88653, 0.99294, 0.78501 },
				{ 0.89552, 0.99765, 0.79499 },
				{ 0.89718, 0.99765, 0.79499 },
				{ 0.89162, 0.99294, 0.78501 },
				{ 0.88619, 0.98824, 0.77509 },
				{ 0.88087, 0.98353, 0.76522 },
				{ 0.87566, 0.97882, 0.75542 },
				{ 0.87057, 0.97412, 0.74568 },
				{ 0.86559, 0.96941, 0.73599 },
				{ 0.86072, 0.96471, 0.72637 },
				{ 0.85596, 0.96, 0.7168 },
				{ 0.85131, 0.95529, 0.70729 },
				{ 0.84676, 0.95059, 0.69784 },
				{ 0.84232, 0.94588, 0.68845 },
				{ 0.83798, 0.94118, 0.67912 },
				{ 0.83374, 0.93647, 0.66985 },
				{ 0.82961, 0.93176, 0.66064 },
				{ 0.82557, 0.92706, 0.65149 },
				{ 0.82162, 0.92235, 0.64239 },
				{ 0.81777, 0.91765, 0.63336 },
				{ 0.81402, 0.91294, 0.62438 },
				{ 0.81036, 0.90824, 0.61546 },
				{ 0.80679, 0.90353, 0.6066 },
				{ 0.8033, 0.89882, 0.59781 },
				{ 0.79991, 0.89412, 0.58907 },
				{ 0.7966, 0.88941, 0.58038 },
				{ 0.79338, 0.88471, 0.57176 },
				{ 0.79024, 0.88, 0.5632 },
				{ 0.78718, 0.87529, 0.5547 },
				{ 0.7842, 0.87059, 0.54625 },
				{ 0.78131, 0.86588, 0.53787 },
				{ 0.77848, 0.86118, 0.52954 },
				{ 0.77574, 0.85647, 0.52127 },
				{ 0.77307, 0.85176, 0.51306 },
				{ 0.77047, 0.84706, 0.50491 },
				{ 0.76794, 0.84235, 0.49682 },
				{ 0.76548, 0.83765, 0.48879 },
				{ 0.76309, 0.83294, 0.48082 },
				{ 0.76077, 0.82824, 0.47291 },
				{ 0.75851, 0.82353, 0.46505 },
				{ 0.75632, 0.81882, 0.45726 },
				{ 0.75419, 0.81412, 0.44952 },
				{ 0.75211, 0.80941, 0.44184 },
				{ 0.7501, 0.80471, 0.43423 },
				{ 0.74815, 0.8, 0.42667 },
				{ 0.74625, 0.79529, 0.41917 },
				{ 0.74441, 0.79059, 0.41173 },
				{ 0.74262, 0.78588, 0.40434 },
				{ 0.74088, 0.78118, 0.39702 },
				{ 0.73919, 0.77647, 0.38976 },
				{ 0.73755, 0.77176, 0.38255 },
				{ 0.73596, 0.76706, 0.37541 },
				{ 0.73441, 0.76235, 0.36832 },
				{ 0.73291, 0.75765, 0.36129 },
				{ 0.73145, 0.75294, 0.35433 },
				{ 0.73003, 0.74824, 0.34742 },
				{ 0.72865, 0.74353, 0.34057 },
				{ 0.72731, 0.73882, 0.33377 },
				{ 0.726, 0.73412, 0.32704 },
				{ 0.72473, 0.72941, 0.32037 },
				{ 0.7235, 0.72471, 0.31376 },
				{ 0.72, 0.71771, 0.3072 },
				{ 0.71529, 0.70947, 0.3007 },
				{ 0.71059, 0.7012, 0.29427 },
				{ 0.70588, 0.69291, 0.28789 },
				{ 0.70118, 0.68458, 0.28157 },
				{ 0.69647, 0.67624, 0.27531 },
				{ 0.69176, 0.66787, 0.26911 },
				{ 0.68706, 0.65948, 0.26297 },
				{ 0.68235, 0.65107, 0.25689 },
				{ 0.67765, 0.64264, 0.25086 },
				{ 0.67294, 0.63419, 0.2449 },
				{ 0.66824, 0.62573, 0.23899 },
				{ 0.66353, 0.61726, 0.23315 },
				{ 0.65882, 0.60877, 0.22736 },
				{ 0.65412, 0.60027, 0.22163 },
				{ 0.64941, 0.59176, 0.21596 },
				{ 0.64471, 0.58324, 0.21035 },
				{ 0.64, 0.57472, 0.2048 },
				{ 0.63529, 0.56619, 0.19931 },
				{ 0.63059, 0.55766, 0.19387 },
				{ 0.62588, 0.54913, 0.1885 },
				{ 0.62118, 0.54059, 0.18319 },
				{ 0.61647, 0.53206, 0.17793 },
				{ 0.61176, 0.52353, 0.17273 },
				{ 0.60706, 0.515, 0.1676 },
				{ 0.60235, 0.50648, 0.16252 },
				{ 0.59765, 0.49797, 0.1575 },
				{ 0.59294, 0.48946, 0.15254 },
				{ 0.58824, 0.48097, 0.14764 },
				{ 0.58353, 0.47248, 0.14279 },
				{ 0.57882, 0.46401, 0.13801 },
				{ 0.57412, 0.45555, 0.13329 },
				{ 0.56941, 0.44711, 0.12862 },
				{ 0.56471, 0.43869, 0.12401 },
				{ 0.56, 0.43029, 0.11947 },
				{ 0.55529, 0.4219, 0.11498 },
				{ 0.55059, 0.41354, 0.11055 },
				{ 0.54588, 0.40521, 0.10618 },
				{ 0.54118, 0.39689, 0.10187 },
				{ 0.53647, 0.38861, 0.097617 },
				{ 0.53176, 0.38035, 0.093424 },
				{ 0.52706, 0.37212, 0.08929 },
				{ 0.52235, 0.36393, 0.085215 },
				{ 0.51765, 0.35576, 0.0812 },
				{ 0.51294, 0.34763, 0.077243 },
				{ 0.50824, 0.33954, 0.073345 },
				{ 0.50353, 0.33148, 0.069507 },
				{ 0.49882, 0.32346, 0.065727 },
				{ 0.49412, 0.31548, 0.062007 },
				{ 0.48941, 0.30755, 0.058346 },
				{ 0.48471, 0.29965, 0.054743 },
				{ 0.48, 0.2918, 0.0512 },
				{ 0.47529, 0.284, 0.047716 },
				{ 0.47059, 0.27625, 0.044291 },
				{ 0.46588, 0.26854, 0.040925 },
				{ 0.46118, 0.26089, 0.037618 },
				{ 0.45647, 0.25328, 0.03437 },
				{ 0.45176, 0.24573, 0.031181 },
				{ 0.44706, 0.23824, 0.028051 },
				{ 0.44235, 0.2308, 0.02498 },
				{ 0.43765, 0.22342, 0.021968 },
				{ 0.43294, 0.2161, 0.019015 },
				{ 0.42824, 0.20885, 0.016122 },
				{ 0.42353, 0.20165, 0.013287 },
				{ 0.41882, 0.19452, 0.010512 },
				{ 0.41412, 0.18745, 0.0077952 },
				{ 0.40941, 0.18046, 0.0051377 },
				{ 0.40471, 0.17353, 0.0025393 },
				{ 0.4, 0.16667, 0 } };

		cmap_land = new int[n];
		for (int i = 0; i < n; i++) {
			double it = 1.0 * i / (n - 1) * 255;
			int left = (int) (it);
			if (left >= 255) {
				left = 254;
			}
			int right = left + 1;

			int R = (int) (((it - left) * (C[right][0] - C[left][0]) + C[left][0]) * 255);
			int G = (int) (((it - left) * (C[right][1] - C[left][1]) + C[left][1]) * 255);
			int B = (int) (((it - left) * (C[right][2] - C[left][2]) + C[left][2]) * 255);
			cmap_land[i] = new Color(R, G, B).getRGB();
		}
		cmap = cmap_land;
	}

	public void parula(int n) {
		length = n;
		double[][] C = { { 0.2081, 0.1663, 0.5292 },
				{ 0.2091, 0.1721, 0.5411 },
				{ 0.2101, 0.1779, 0.5530 },
				{ 0.2109, 0.1837, 0.5650 },
				{ 0.2116, 0.1895, 0.5771 },
				{ 0.2121, 0.1954, 0.5892 },
				{ 0.2124, 0.2013, 0.6013 },
				{ 0.2125, 0.2072, 0.6135 },
				{ 0.2123, 0.2132, 0.6258 },
				{ 0.2118, 0.2192, 0.6381 },
				{ 0.2111, 0.2253, 0.6505 },
				{ 0.2099, 0.2315, 0.6629 },
				{ 0.2084, 0.2377, 0.6753 },
				{ 0.2063, 0.2440, 0.6878 },
				{ 0.2038, 0.2503, 0.7003 },
				{ 0.2006, 0.2568, 0.7129 },
				{ 0.1968, 0.2632, 0.7255 },
				{ 0.1921, 0.2698, 0.7381 },
				{ 0.1867, 0.2764, 0.7507 },
				{ 0.1802, 0.2832, 0.7634 },
				{ 0.1728, 0.2902, 0.7762 },
				{ 0.1641, 0.2975, 0.7890 },
				{ 0.1541, 0.3052, 0.8017 },
				{ 0.1427, 0.3132, 0.8145 },
				{ 0.1295, 0.3217, 0.8269 },
				{ 0.1147, 0.3306, 0.8387 },
				{ 0.0986, 0.3397, 0.8495 },
				{ 0.0816, 0.3486, 0.8588 },
				{ 0.0646, 0.3572, 0.8664 },
				{ 0.0482, 0.3651, 0.8722 },
				{ 0.0329, 0.3724, 0.8765 },
				{ 0.0213, 0.3792, 0.8796 },
				{ 0.0136, 0.3853, 0.8815 },
				{ 0.0086, 0.3911, 0.8827 },
				{ 0.0060, 0.3965, 0.8833 },
				{ 0.0051, 0.4017, 0.8834 },
				{ 0.0054, 0.4066, 0.8831 },
				{ 0.0067, 0.4113, 0.8825 },
				{ 0.0089, 0.4159, 0.8816 },
				{ 0.0116, 0.4203, 0.8805 },
				{ 0.0148, 0.4246, 0.8793 },
				{ 0.0184, 0.4288, 0.8779 },
				{ 0.0223, 0.4329, 0.8763 },
				{ 0.0264, 0.4370, 0.8747 },
				{ 0.0306, 0.4410, 0.8729 },
				{ 0.0349, 0.4449, 0.8711 },
				{ 0.0394, 0.4488, 0.8692 },
				{ 0.0437, 0.4526, 0.8672 },
				{ 0.0477, 0.4564, 0.8652 },
				{ 0.0514, 0.4602, 0.8632 },
				{ 0.0549, 0.4640, 0.8611 },
				{ 0.0582, 0.4677, 0.8589 },
				{ 0.0612, 0.4714, 0.8568 },
				{ 0.0640, 0.4751, 0.8546 },
				{ 0.0666, 0.4788, 0.8525 },
				{ 0.0689, 0.4825, 0.8503 },
				{ 0.0710, 0.4862, 0.8481 },
				{ 0.0729, 0.4899, 0.8460 },
				{ 0.0746, 0.4937, 0.8439 },
				{ 0.0761, 0.4974, 0.8418 },
				{ 0.0773, 0.5012, 0.8398 },
				{ 0.0782, 0.5051, 0.8378 },
				{ 0.0789, 0.5089, 0.8359 },
				{ 0.0794, 0.5129, 0.8341 },
				{ 0.0795, 0.5169, 0.8324 },
				{ 0.0793, 0.5210, 0.8308 },
				{ 0.0788, 0.5251, 0.8293 },
				{ 0.0778, 0.5295, 0.8280 },
				{ 0.0764, 0.5339, 0.8270 },
				{ 0.0746, 0.5384, 0.8261 },
				{ 0.0724, 0.5431, 0.8253 },
				{ 0.0698, 0.5479, 0.8247 },
				{ 0.0668, 0.5527, 0.8243 },
				{ 0.0636, 0.5577, 0.8239 },
				{ 0.0600, 0.5627, 0.8237 },
				{ 0.0562, 0.5677, 0.8234 },
				{ 0.0523, 0.5727, 0.8231 },
				{ 0.0484, 0.5777, 0.8228 },
				{ 0.0445, 0.5826, 0.8223 },
				{ 0.0408, 0.5874, 0.8217 },
				{ 0.0372, 0.5922, 0.8209 },
				{ 0.0342, 0.5968, 0.8198 },
				{ 0.0317, 0.6012, 0.8186 },
				{ 0.0296, 0.6055, 0.8171 },
				{ 0.0279, 0.6097, 0.8154 },
				{ 0.0265, 0.6137, 0.8135 },
				{ 0.0255, 0.6176, 0.8114 },
				{ 0.0248, 0.6214, 0.8091 },
				{ 0.0243, 0.6250, 0.8066 },
				{ 0.0239, 0.6285, 0.8039 },
				{ 0.0237, 0.6319, 0.8010 },
				{ 0.0235, 0.6352, 0.7980 },
				{ 0.0233, 0.6384, 0.7948 },
				{ 0.0231, 0.6415, 0.7916 },
				{ 0.0230, 0.6445, 0.7881 },
				{ 0.0229, 0.6474, 0.7846 },
				{ 0.0227, 0.6503, 0.7810 },
				{ 0.0227, 0.6531, 0.7773 },
				{ 0.0232, 0.6558, 0.7735 },
				{ 0.0238, 0.6585, 0.7696 },
				{ 0.0246, 0.6611, 0.7656 },
				{ 0.0263, 0.6637, 0.7615 },
				{ 0.0282, 0.6663, 0.7574 },
				{ 0.0306, 0.6688, 0.7532 },
				{ 0.0338, 0.6712, 0.7490 },
				{ 0.0373, 0.6737, 0.7446 },
				{ 0.0418, 0.6761, 0.7402 },
				{ 0.0467, 0.6784, 0.7358 },
				{ 0.0516, 0.6808, 0.7313 },
				{ 0.0574, 0.6831, 0.7267 },
				{ 0.0629, 0.6854, 0.7221 },
				{ 0.0692, 0.6877, 0.7173 },
				{ 0.0755, 0.6899, 0.7126 },
				{ 0.0820, 0.6921, 0.7078 },
				{ 0.0889, 0.6943, 0.7029 },
				{ 0.0956, 0.6965, 0.6979 },
				{ 0.1031, 0.6986, 0.6929 },
				{ 0.1104, 0.7007, 0.6878 },
				{ 0.1180, 0.7028, 0.6827 },
				{ 0.1258, 0.7049, 0.6775 },
				{ 0.1335, 0.7069, 0.6723 },
				{ 0.1418, 0.7089, 0.6669 },
				{ 0.1499, 0.7109, 0.6616 },
				{ 0.1585, 0.7129, 0.6561 },
				{ 0.1671, 0.7148, 0.6507 },
				{ 0.1758, 0.7168, 0.6451 },
				{ 0.1849, 0.7186, 0.6395 },
				{ 0.1938, 0.7205, 0.6338 },
				{ 0.2033, 0.7223, 0.6281 },
				{ 0.2128, 0.7241, 0.6223 },
				{ 0.2224, 0.7259, 0.6165 },
				{ 0.2324, 0.7275, 0.6107 },
				{ 0.2423, 0.7292, 0.6048 },
				{ 0.2527, 0.7308, 0.5988 },
				{ 0.2631, 0.7324, 0.5929 },
				{ 0.2735, 0.7339, 0.5869 },
				{ 0.2845, 0.7354, 0.5809 },
				{ 0.2953, 0.7368, 0.5749 },
				{ 0.3064, 0.7381, 0.5689 },
				{ 0.3177, 0.7394, 0.5630 },
				{ 0.3289, 0.7406, 0.5570 },
				{ 0.3405, 0.7417, 0.5512 },
				{ 0.3520, 0.7428, 0.5453 },
				{ 0.3635, 0.7438, 0.5396 },
				{ 0.3753, 0.7446, 0.5339 },
				{ 0.3869, 0.7454, 0.5283 },
				{ 0.3986, 0.7461, 0.5229 },
				{ 0.4103, 0.7467, 0.5175 },
				{ 0.4218, 0.7473, 0.5123 },
				{ 0.4334, 0.7477, 0.5072 },
				{ 0.4447, 0.7482, 0.5021 },
				{ 0.4561, 0.7485, 0.4972 },
				{ 0.4672, 0.7487, 0.4924 },
				{ 0.4783, 0.7489, 0.4877 },
				{ 0.4892, 0.7491, 0.4831 },
				{ 0.5000, 0.7491, 0.4786 },
				{ 0.5106, 0.7492, 0.4741 },
				{ 0.5212, 0.7492, 0.4698 },
				{ 0.5315, 0.7491, 0.4655 },
				{ 0.5418, 0.7490, 0.4613 },
				{ 0.5519, 0.7489, 0.4571 },
				{ 0.5619, 0.7487, 0.4531 },
				{ 0.5718, 0.7485, 0.4490 },
				{ 0.5816, 0.7482, 0.4451 },
				{ 0.5913, 0.7479, 0.4412 },
				{ 0.6009, 0.7476, 0.4374 },
				{ 0.6103, 0.7473, 0.4335 },
				{ 0.6197, 0.7469, 0.4298 },
				{ 0.6290, 0.7465, 0.4261 },
				{ 0.6382, 0.7460, 0.4224 },
				{ 0.6473, 0.7456, 0.4188 },
				{ 0.6564, 0.7451, 0.4152 },
				{ 0.6653, 0.7446, 0.4116 },
				{ 0.6742, 0.7441, 0.4081 },
				{ 0.6830, 0.7435, 0.4046 },
				{ 0.6918, 0.7430, 0.4011 },
				{ 0.7004, 0.7424, 0.3976 },
				{ 0.7091, 0.7418, 0.3942 },
				{ 0.7176, 0.7412, 0.3908 },
				{ 0.7261, 0.7405, 0.3874 },
				{ 0.7346, 0.7399, 0.3840 },
				{ 0.7430, 0.7392, 0.3806 },
				{ 0.7513, 0.7385, 0.3773 },
				{ 0.7596, 0.7378, 0.3739 },
				{ 0.7679, 0.7372, 0.3706 },
				{ 0.7761, 0.7364, 0.3673 },
				{ 0.7843, 0.7357, 0.3639 },
				{ 0.7924, 0.7350, 0.3606 },
				{ 0.8005, 0.7343, 0.3573 },
				{ 0.8085, 0.7336, 0.3539 },
				{ 0.8166, 0.7329, 0.3506 },
				{ 0.8246, 0.7322, 0.3472 },
				{ 0.8325, 0.7315, 0.3438 },
				{ 0.8405, 0.7308, 0.3404 },
				{ 0.8484, 0.7301, 0.3370 },
				{ 0.8563, 0.7294, 0.3336 },
				{ 0.8642, 0.7288, 0.3300 },
				{ 0.8720, 0.7282, 0.3265 },
				{ 0.8798, 0.7276, 0.3229 },
				{ 0.8877, 0.7271, 0.3193 },
				{ 0.8954, 0.7266, 0.3156 },
				{ 0.9032, 0.7262, 0.3117 },
				{ 0.9110, 0.7259, 0.3078 },
				{ 0.9187, 0.7256, 0.3038 },
				{ 0.9264, 0.7256, 0.2996 },
				{ 0.9341, 0.7256, 0.2953 },
				{ 0.9417, 0.7259, 0.2907 },
				{ 0.9493, 0.7264, 0.2859 },
				{ 0.9567, 0.7273, 0.2808 },
				{ 0.9639, 0.7285, 0.2754 },
				{ 0.9708, 0.7303, 0.2696 },
				{ 0.9773, 0.7326, 0.2634 },
				{ 0.9831, 0.7355, 0.2570 },
				{ 0.9882, 0.7390, 0.2504 },
				{ 0.9922, 0.7431, 0.2437 },
				{ 0.9952, 0.7476, 0.2373 },
				{ 0.9973, 0.7524, 0.2310 },
				{ 0.9986, 0.7573, 0.2251 },
				{ 0.9991, 0.7624, 0.2195 },
				{ 0.9990, 0.7675, 0.2141 },
				{ 0.9985, 0.7726, 0.2090 },
				{ 0.9976, 0.7778, 0.2042 },
				{ 0.9964, 0.7829, 0.1995 },
				{ 0.9950, 0.7880, 0.1949 },
				{ 0.9933, 0.7931, 0.1905 },
				{ 0.9914, 0.7981, 0.1863 },
				{ 0.9894, 0.8032, 0.1821 },
				{ 0.9873, 0.8083, 0.1780 },
				{ 0.9851, 0.8133, 0.1740 },
				{ 0.9828, 0.8184, 0.1700 },
				{ 0.9805, 0.8235, 0.1661 },
				{ 0.9782, 0.8286, 0.1622 },
				{ 0.9759, 0.8337, 0.1583 },
				{ 0.9736, 0.8389, 0.1544 },
				{ 0.9713, 0.8441, 0.1505 },
				{ 0.9692, 0.8494, 0.1465 },
				{ 0.9672, 0.8548, 0.1425 },
				{ 0.9654, 0.8603, 0.1385 },
				{ 0.9638, 0.8659, 0.1343 },
				{ 0.9623, 0.8716, 0.1301 },
				{ 0.9611, 0.8774, 0.1258 },
				{ 0.9600, 0.8834, 0.1215 },
				{ 0.9593, 0.8895, 0.1171 },
				{ 0.9588, 0.8958, 0.1126 },
				{ 0.9586, 0.9022, 0.1082 },
				{ 0.9587, 0.9088, 0.1036 },
				{ 0.9591, 0.9155, 0.0990 },
				{ 0.9599, 0.9225, 0.0944 },
				{ 0.9610, 0.9296, 0.0897 },
				{ 0.9624, 0.9368, 0.0850 },
				{ 0.9641, 0.9443, 0.0802 },
				{ 0.9662, 0.9518, 0.0753 },
				{ 0.9685, 0.9595, 0.0703 },
				{ 0.9710, 0.9673, 0.0651 },
				{ 0.9736, 0.9752, 0.0597 },
				{ 0.9763, 0.9831, 0.0538 } };

		cmap = new int[n];
		for (int i = 0; i < n; i++) {
			double it = 1.0 * i / (n - 1) * 255;
			int left = (int) (it);
			if (left >= 255) {
				left = 254;
			}
			int right = left + 1;
			int R = (int) (((it - left) * (C[right][0] - C[left][0]) + C[left][0]) * 255);
			int G = (int) (((it - left) * (C[right][1] - C[left][1]) + C[left][1]) * 255);
			int B = (int) (((it - left) * (C[right][2] - C[left][2]) + C[left][2]) * 255);
			cmap[i] = new Color(R, G, B).getRGB();
		}
	}

	public void jet(int n) {
		length = n;
		cmap = new int[n];
		for (int i = 0; i < n; i++) {
			double x = 1.0 * i / (n - 1);
			int R = (int) (255 * Math.exp(-60 * Math.pow(Math.abs(x - 0.75), 3.2)));
			int G = (int) (255 * Math.exp(-60 * Math.pow(Math.abs(x - 0.5), 3.2)));
			int B = (int) (255 * Math.exp(-60 * Math.pow(Math.abs(x - 0.25), 3.2)));
			cmap[i] = new Color(R, G, B).getRGB();
		}
	}

	public void demcmap(int n) {
		sea(n);
		land(n);
	}

	public int getRGB(double z) throws Exception {
		if (z < zmin) {
			throw new Exception(z + " is smaller than the setted minimum value " + zmin + ".");
		}
		if (z > zmax) {
			throw new Exception(z + " is bigger than the setted maximum value " + zmax + ".");
		}

		if (cmap_sea != null && cmap_land != null) {
			if (zmin == 0 && zmax == 0) {
				return deep_sea;
			}
			if (z <= 0) {
				int it_sea = (int) (1.0 * (zmin - z) / zmin * (length - 1));
				return cmap_sea[it_sea];
			} else {
				int it_land = (int) (1.0 * z / zmax * (length - 1));
				return cmap_land[it_land];
			}
		} else {
			int it = (int) (1.0 * (z - zmin) / (zmax - zmin) * (length - 1));
			return cmap[it];
		}
	}
}
