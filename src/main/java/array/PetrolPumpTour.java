package array;

public class PetrolPumpTour {

    public static class PetrolPump {
        int petrol;
        int distanceToNextPetrolPump;

        public PetrolPump(int petrol, int distanceToNextPetrolPump) {
            super();
            this.petrol = petrol;
            this.distanceToNextPetrolPump = distanceToNextPetrolPump;
        }
    }

    public static void main(String[] args) {
        int[][] array = {{6, 4}, {3, 5}, {3, 4}, {7, 3}};

        PetrolPump[] petrolPumps = new PetrolPump[array.length];
        for (int i = 0; i < array.length; i++) {
            int[] tmp = array[i];

            petrolPumps[i] = new PetrolPump(tmp[0], tmp[1]);
        }

        System.out.println(getTourStart(petrolPumps));
    }

    private static int getTourStart(PetrolPump[] petrolPumps) {
        int start = 0;
        int end = 1;
        int n = petrolPumps.length;

        int currPetrol = petrolPumps[start].petrol - petrolPumps[start].distanceToNextPetrolPump;

        while (start != end) {
            while (currPetrol < 0 && start != end) {
                currPetrol = currPetrol - (petrolPumps[start].petrol - petrolPumps[start].distanceToNextPetrolPump);
                start = (start + 1) % n;

                if (start == 0) {
                    return -1;
                }
            }

            currPetrol = currPetrol + (petrolPumps[end].petrol - petrolPumps[end].distanceToNextPetrolPump);
            end = (end + 1) % n;
        }

        return start;
    }

}
