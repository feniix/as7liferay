/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.util.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletInputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class ByteArrayInputStreamWrapper extends ServletInputStream {

	public ByteArrayInputStreamWrapper(
		ByteArrayInputStream byteArrayInputStream) {

		_byteArrayInputStream = byteArrayInputStream;
	}

	public int available() {
		return _byteArrayInputStream.available();
	}

	public void close() throws IOException {
		_byteArrayInputStream.close();
	}

	public void mark(int readLimit) {
		_byteArrayInputStream.mark(readLimit);
	}

	public boolean markSupported() {
		return _byteArrayInputStream.markSupported();
	}

	public int read() {
		return _byteArrayInputStream.read();
	}

	public int read(byte[] byteArray) throws IOException {
		return _byteArrayInputStream.read(byteArray);
	}

	public int read(byte[] byteArray, int offset, int length) {
		return _byteArrayInputStream.read(byteArray, offset, length);
	}

	public int readLine(byte[] byteArray, int offset, int length) {
		return _byteArrayInputStream.read(byteArray, offset, length);
	}

	public void reset() {
		_byteArrayInputStream.reset();
	}

	public long skip(long skip) {
		return _byteArrayInputStream.skip(skip);
	}

	private ByteArrayInputStream _byteArrayInputStream;

}