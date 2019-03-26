//
// Created by Sunguk Ham on 2018-12-02.
//

#ifndef ASSIGNMENT3_HEAP_HPP
#define ASSIGNMENT3_HEAP_HPP

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * Heap class
 * @tparam E any type
 */
template <class E>
class heap {

public:
    /**
     * default constructor
     */
    heap() = default;

    /**
     * constructor accepts begin and end iterator
     * @tparam Iterator iterator type
     * @param begin begin
     * @param end end
     */
    template <class Iterator>
    heap(Iterator begin, Iterator end) {
        while (begin != end) {
            this->vec.emplace_back(*begin++);
        }
        heapify();
    }

    /**
     * push element to the heap
     * @param element element
     */
    void push(E element) {
        vec.emplace_back(element);
        heapify();
    }

    /**
     * pop the top element on the heap
     * @return element
     */
    E pop() {
        if (vec.size() == 0) {
            throw exception();
        }
        iter_swap(this->vec.begin(), this->vec.begin() + (vec.size() - 1));
        E element = this->vec.at(vec.size() - 1);
        vec.erase(vec.begin() + (vec.size() - 1));
        heapify();
        return element;
    }

    /**
     * size of the heap
     * @return size
     */
    int size() {
        return static_cast<int>(vec.size());
    }

    /**
     * checks if empty
     * @return true if empty, false otherwise
     */
    bool is_empty() {
        return this->vec.size() == 0;
    }

    /**
     * clear the heap
     */
    void clear() {
        this->vec.clear();
    }

    /**
     * insertion operator overload
     * @param os ostream
     * @param heap1 heap
     * @return ostream
     */
    friend ostream& operator<<(ostream& os, const heap<E>& heap1) {
        for (const auto& element : heap1.vec) {
            os << element << endl;
        }
        return os;
    }

private:
    vector<E> vec;

    /**
     * heapify
     */
    void heapify() {
        for (int i = 1; i < vec.size(); i++) {
            if ((vec.at(i)) > (vec.at((i - 1) / 2))) {
                int j = i;
                while ((vec.at(j)) > (vec.at((j - 1) / 2))) {
                    iter_swap(vec.begin() + j, vec.begin() + ((j - 1) / 2));
                    j = (j - 1) / 2;
                }
            }
        }
    }
};

#endif //ASSIGNMENT3_HEAP_HPP
