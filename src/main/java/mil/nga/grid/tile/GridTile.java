package mil.nga.grid.tile;

import mil.nga.grid.GridUtils;
import mil.nga.grid.features.Bounds;
import mil.nga.grid.features.Point;
import mil.nga.grid.features.Unit;

/**
 * Grid Tile
 * 
 * @author osbornb
 */
public class GridTile {

	/**
	 * Tile width
	 */
	private int width;

	/**
	 * Tile height
	 */
	private int height;

	/**
	 * Zoom level
	 */
	private int zoom;

	/**
	 * Bounds
	 */
	private Bounds bounds;

	/**
	 * Create a tile
	 * 
	 * @param width
	 *            tile width
	 * @param height
	 *            tile height
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param zoom
	 *            zoom level
	 * @return tile
	 */
	public static GridTile create(int width, int height, int x, int y,
			int zoom) {
		return new GridTile(width, height, x, y, zoom);
	}

	/**
	 * Create a tile
	 * 
	 * @param width
	 *            tile width
	 * @param height
	 *            tile height
	 * @param bounds
	 *            tile bounds
	 * @return tile
	 */
	public static GridTile create(int width, int height, Bounds bounds) {
		return new GridTile(width, height, bounds);
	}

	/**
	 * Constructor
	 * 
	 * @param width
	 *            tile width
	 * @param height
	 *            tile height
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param zoom
	 *            zoom level
	 */
	public GridTile(int width, int height, int x, int y, int zoom) {
		this.width = width;
		this.height = height;
		this.zoom = zoom;
		this.bounds = GridUtils.getBounds(x, y, zoom);
	}

	/**
	 * Constructor
	 * 
	 * @param width
	 *            tile width
	 * @param height
	 *            tile height
	 * @param bounds
	 *            tile bounds
	 */
	public GridTile(int width, int height, Bounds bounds) {
		this.width = width;
		this.height = height;
		this.bounds = bounds;
		this.zoom = (int) Math.round(GridUtils.getZoomLevel(bounds));
	}

	/**
	 * Get the tile width
	 * 
	 * @return tile width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get the tile height
	 * 
	 * @return tile height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the zoom level
	 * 
	 * @return zoom level
	 */
	public int getZoom() {
		return zoom;
	}

	/**
	 * Get the tile bounds
	 * 
	 * @return bounds
	 */
	public Bounds getBounds() {
		return bounds;
	}

	/**
	 * Get the bounds in the units
	 * 
	 * @param unit
	 *            units
	 * @return bounds in units
	 */
	public Bounds getBounds(Unit unit) {
		return bounds.toUnit(unit);
	}

	/**
	 * Get the bounds in degrees
	 * 
	 * @return bounds in degrees
	 */
	public Bounds getBoundsDegrees() {
		return getBounds(Unit.DEGREE);
	}

	/**
	 * Get the bounds in meters
	 * 
	 * @return bounds in meters
	 */
	public Bounds getBoundsMeters() {
		return getBounds(Unit.METER);
	}

	/**
	 * Get the point pixel location in the tile
	 * 
	 * @param point
	 *            point
	 * @return pixel
	 */
	public Pixel getPixel(Point point) {
		return GridUtils.getPixel(width, height, bounds, point);
	}

	/**
	 * Get the longitude in meters x pixel location in the tile
	 * 
	 * @param longitude
	 *            longitude in meters
	 * @return x pixel
	 */
	public float getXPixel(double longitude) {
		return GridUtils.getXPixel(width, bounds, longitude);
	}

	/**
	 * Get the latitude (in meters) y pixel location in the tile
	 * 
	 * @param latitude
	 *            latitude in meters
	 * @return y pixel
	 */
	public float getYPixel(double latitude) {
		return GridUtils.getYPixel(height, bounds, latitude);
	}

}
