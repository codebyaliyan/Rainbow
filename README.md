# Rainbow 🌈

A small Java Swing application that draws a rainbow using concentric colored arcs on a `JPanel`.

| | |
|---|---|
| **Developer** | Aliyan Ahmad |
| **Language** | Java (JDK 8 or higher) |
| **Libraries** | `javax.swing`, `java.awt` (no external dependencies) |
| **Type** | Desktop GUI (Swing) |

## Features
- Seven-band rainbow in the standard color order
- Anti-aliased (smooth) edges using `RenderingHints`
- Rainbow stays centered at the bottom when the window is resized, because it is redrawn from the current window size
- Window opens centered on the screen
- Single file, no setup required

## How It Works
1. **Colors:** the seven colors are stored in a `Color[]` array. Indigo and Violet are custom RGB colors, since `java.awt.Color` has no built-in constants for them.
2. **Class:** `Rainbow` extends `JPanel` and overrides `paintComponent(Graphics g)` to do the drawing.
3. **Geometry:** the center point is the bottom middle of the panel (`getWidth() / 2`, `getHeight()`). Each band is 40 px wide, so the largest radius is `7 x 40 = 280` px.
4. **Drawing order:** `fillArc()` draws a filled half circle (start angle 0, sweep 180) for each color. The largest (red) is drawn first and smaller arcs are painted on top, so each color shows as a ring around the next one. The smallest arc (violet) remains as a solid half circle in the center.
5. **Window:** `main()` creates a `JFrame`, adds the panel, centers it on screen and makes it visible.

| Color | Radius (px) |
|---|---|
| Red | 280 |
| Orange | 240 |
| Yellow | 200 |
| Green | 160 |
| Blue | 120 |
| Indigo | 80 |
| Violet | 40 |

## Requirements
- JDK 8 or higher (check with `java -version`)

## How to Compile and Run
```bash
javac Rainbow.java
java Rainbow
```

## Project Structure
```
Rainbow/
|-- Rainbow.java
|-- README.md
```

## Customization
Change these values in `Rainbow.java`:

| What | Where | Example |
|---|---|---|
| Band thickness | `int bandWidth = 40;` | `60` for a bigger rainbow |
| Colors | `RAINBOW_COLORS` array | add or replace any `Color` |
| Window size | `frame.setSize(800, 500);` | `1000, 600` |
| Hollow center | Draw a background-colored arc last | see Future Improvements |

## Concepts Practiced
- Custom painting with `paintComponent()` and `Graphics2D`
- Inheritance (`extends JPanel`) and method overriding
- Arrays and loops
- Basic geometry with arcs and radii
- Anti-aliasing with `RenderingHints`

## Future Improvements
- Make the center hollow by drawing a background-colored arc over the violet band
- Scale band width automatically with window size
- Add a sky background, sun and clouds
- Launch the window with `SwingUtilities.invokeLater()` (the recommended way to start Swing apps)
- Add animation that draws the bands one by one

## License
Free to use for learning purposes.
