package frc.robot.utilities;

public class MiscUtils {

    /**
     * This class will contain miscellaneous methods that are used by multiple classes
     */
    
    public static double bearingToRefAngle(double bearing) {
        // Angle arm is on an axis
        if (((bearing + 90) % 360) == 0 || ((bearing + 90) % 360) == 90 || ((bearing + 90) % 360) == 180 || ((bearing + 90) % 360) == 270) {
            return (bearing + 90) % 360;
        } else if ((bearing + 90) % 360 < 90) { // 1st quadrant
            return 90 - ((bearing + 90) % 360);
        } else if ((bearing + 90) % 360 > 270) { // 2nd quadrant
            return 90 - (360 - ((bearing + 90) % 360));
        } else if ((bearing + 90) % 360 < 270 && (bearing + 90) % 360 > 180) { // 3rd quadrant
            return 270 - ((bearing + 90) % 360);
        } else if ((bearing + 90) % 360 < 180 && (bearing + 90) % 360 > 90) { // 4th quadrant
            return (((bearing + 90) % 360) - 90);
        } else {
            System.out.println("Error in bearingToRefAngle() in PositionPredictor.java, this shouldn't be possible!");
            return 0;
        }
    }

    public static double refAngleToBearing(double x, double y, double refAngle) {
        if (x >= 0 && y >= 0) { // Origin & pos y axis
            return 0;
        } else if (x > 0 && y == 0) { // Pos x axis
            return 90;
        } else if (x == 0 && y < 0) { // Neg y axis
            return 180;
        } else if (x < 0 && y == 0) { // Neg x axis
            return 270;
        } else if (x > 0 && y > 0) { // 1st quadrant
            return 90 - refAngle;
        } else if (x < 0 && y > 0) { // 2nd quadrant
            return 360 - (refAngle - 90);
        } else if (x < 0 && y < 0) { // 3rd quadrant
            return 270 - (refAngle - 180);
        } else if (x > 0 && y < 0) { // 4th quadrant
            return 180 - (refAngle - 270);
        } else { // Shouldn't happen
            System.out.println("Error in refAngleToBearing somewhere, you shouldn't be here!");
            return 0;
        }
    }

    public static _Vector addVectors(_Vector... vectors) {
        _Vector returnVector = new _Vector(0, 0);
        double x = 0;
        double y = 0;

        for (_Vector vector : vectors) {
            x += vector.getX();
            y += vector.getY();
        }

        returnVector.setXandY(x, y);

        return returnVector;
    }
}