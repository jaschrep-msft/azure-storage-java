/*
 * Copyright Microsoft Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoft.azure.storage.blob;

import java.net.Inet4Address;

/**
 * This type specifies a continuous range of IP addresses. It is used to limit permissions on SAS tokens. Null may be
 * set if it is not desired to confine the sas permissions to an IP range. Please refer to
 * {@link AccountSASSignatureValues} or {@link ServiceSASSignatureValues} for more information.
 */
public final class IPRange {

    public static final IPRange DEFAULT = new IPRange();

    /**
     * A {@link Inet4Address} representing the minimum IP address of the range.
     */
    public Inet4Address ipMin;

    /**
     * A {@link Inet4Address} representing the maximum IP address of the range.
     */
    public Inet4Address ipMax;

    public IPRange() { }

    /**
     * Output the single IP address or range of IP addresses for.
     *
     * @return
     *      The single IP address or range of IP addresses formatted as a {@code String}.
     */
    @Override
    public String toString() {
        if (this.ipMin == null) {
            return "";
        }
        this.ipMax = this.ipMax == null ? this.ipMin : this.ipMax;
        StringBuilder str = new StringBuilder(this.ipMin.toString());
        if (!this.ipMin.equals(this.ipMax)) {
            str.append('-');
            str.append(this.ipMax.toString());
        }

        return str.toString();
    }
}