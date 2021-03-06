/**
 * Copyright (C) 2012 - 2013 Xeiam LLC http://xeiam.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.btce.dto.account;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Matija Mazi
 */
public class BTCEAccountInfo {

  private final int transactionCount;
  private final int openOrders;
  private final long serverTime;
  private final Rights rights;
  private final Map<String, BigDecimal> funds;

  /**
   * Constructor
   * 
   * @param transactionCount The number of transactions
   * @param openOrders The open orders
   * @param serverTime The server time (Unix time)
   * @param rights The rights
   * @param funds The funds
   */
  public BTCEAccountInfo(@JsonProperty("transaction_count") int transactionCount, @JsonProperty("open_orders") int openOrders, @JsonProperty("server_time") long serverTime,
      @JsonProperty("rights") Rights rights, @JsonProperty("funds") Map<String, BigDecimal> funds) {

    this.transactionCount = transactionCount;
    this.openOrders = openOrders;
    this.serverTime = serverTime;
    this.rights = rights;
    this.funds = funds;
  }

  public int getTransactionCount() {

    return transactionCount;
  }

  public int getOpenOrders() {

    return openOrders;
  }

  public long getServerTime() {

    return serverTime;
  }

  public Rights getRights() {

    return rights;
  }

  public Map<String, BigDecimal> getFunds() {

    return funds;
  }

  @Override
  public String toString() {

    return MessageFormat.format("BTCEAccountInfo[transactionCount={0}, openOrders={1}, serverTime={2}, rights={3}, funds=''{4}''']", transactionCount, openOrders, serverTime, rights, funds);
  }

  public static class Rights {

    private final boolean info, trade, withdraw;

    private Rights(@JsonProperty("info") boolean info, @JsonProperty("trade") boolean trade, @JsonProperty("withdraw") boolean withdraw) {

      this.info = info;
      this.trade = trade;
      this.withdraw = withdraw;
    }

    public boolean isInfo() {

      return info;
    }

    public boolean isTrade() {

      return trade;
    }

    public boolean isWithdraw() {

      return withdraw;
    }

    @Override
    public String toString() {

      return MessageFormat.format("Rights[info={0}, trade={1}, withdraw={2}]", info, trade, withdraw);
    }
  }
}
