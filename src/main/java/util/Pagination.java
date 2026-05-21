package util;

import java.util.List;

public class Pagination<T> {
    public List<T> content;
    public long total_records;
    public int total_pages;
    public int current_page;
    public int size;

    public Pagination(List<T> content, long total_records, int current_page, int size) {
        this.content = content;
        this.total_records = total_records;
        this.total_pages = (int) Math.ceil((double) total_records / size);
        this.current_page = current_page;
        this.size = size;
    }

    public List<T> getContent() {
        return content;
    }

    public long getTotalRecords() {
        return total_records;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public int getCurrentPage() {
        return current_page;
    }

    public int getSize() {
        return size;
    }
}
